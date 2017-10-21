package com.mitocode.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mitocode.model.Persona;
import com.mitocode.model.Telefono;

public class TelefonoDAOImpl implements TelefonoDAO {

	private Connection cx;

	public TelefonoDAOImpl() {
		cx = Conexion.conectar();
	}

	@Override
	public void registrar(List<Telefono> lstTelefonos) throws Exception {
		try{
			//Transaccion
			cx.setAutoCommit(false);
			for(Telefono tel : lstTelefonos){
				String sql = "INSERT INTO telefono(idPersona, numero) VALUES (?,?)";
				PreparedStatement preparedStatement = cx.prepareStatement(sql);
				preparedStatement.setInt(1, tel.getPersona().getId());
				preparedStatement.setString(2, tel.getNumero());
				preparedStatement.executeUpdate();
				preparedStatement.close();
			}
			cx.commit();
		}catch(Exception e){
			e.printStackTrace();
			cx.rollback();
		}

	}

	@Override
	public List<Telefono> listar() throws Exception {
		List<Telefono> lista = new ArrayList<>();
		try {
			String sql = "SELECT t.id, t.idPersona, t.numero, p.nombres, p.apellidos FROM telefono t join persona p on t.idpersona = p.id";
			Statement statement = cx.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Telefono telefono = new Telefono();
				Persona persona = new Persona();
				persona.setId(resultSet.getInt("idpersona"));
				persona.setNombres(resultSet.getString("nombres"));
				persona.setApellidos(resultSet.getString("apellidos"));
				telefono.setId(resultSet.getInt("id"));
				telefono.setPersona(persona);
				telefono.setNumero(resultSet.getString("numero"));
				lista.add(telefono);
			}
			resultSet.close();
			statement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

}
