package com.mitocode.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.mitocode.dao.TelefonoDAO;
import com.mitocode.dao.TelefonoDAOImpl;
import com.mitocode.model.Persona;
import com.mitocode.model.Telefono;

@ManagedBean
@ViewScoped
public class TelefonoBean implements Serializable {

	private int idPersona;
	private Telefono telefono;
	private List<Telefono> lstTelefono;
	private List<Telefono> lstTemporal;
	private TelefonoDAO dao;
	//@ManagedProperty(value = "#{personaBean}")
	//private PersonaBean personaBean;

	public TelefonoBean() {
		telefono = new Telefono();
		lstTelefono = new ArrayList<>();
		lstTemporal = new ArrayList<>();
		dao = new TelefonoDAOImpl();
		//personaBean.listar();
		this.listar();
	}

	public void listar() {
		try {
			lstTelefono = dao.listar();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void agregar() {		
		Telefono tel = new Telefono();
		Persona per = new Persona();		
		tel.setNumero(telefono.getNumero());
		per.setId(this.idPersona);
		tel.setPersona(per);
		lstTemporal.add(tel);
	}

	public void registrar() {
		try {
			dao.registrar(lstTemporal);
			this.listar();
			
			//Esto lo agregue yo
			this.lstTemporal = new ArrayList<>();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * getters & setters
	 */

	public List<Telefono> getLstTelefono() {
		return lstTelefono;
	}

	public void setLstTelefono(List<Telefono> lstTelefono) {
		this.lstTelefono = lstTelefono;
	}

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public Telefono getTelefono() {
		return telefono;
	}

	public void setTelefono(Telefono telefono) {
		this.telefono = telefono;
	}

	public List<Telefono> getLstTemporal() {
		return lstTemporal;
	}

	public void setLstTemporal(List<Telefono> lstTemporal) {
		this.lstTemporal = lstTemporal;
	}

}
