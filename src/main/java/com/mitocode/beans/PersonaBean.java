package com.mitocode.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.UploadedFile;

import com.mitocode.dao.PersonaDAO;
import com.mitocode.dao.PersonaDAOImpl;
import com.mitocode.model.Persona;

@ManagedBean(name = "personaBean")
@SessionScoped
public class PersonaBean {

	private List<Persona> lista;
	private PersonaDAO dao;
	private Persona persona;
	private UploadedFile foto;

	public PersonaBean() {
		dao = new PersonaDAOImpl();
		persona = new Persona();
		this.listar();	
	}

	public void listar() {
		try {
			lista = dao.listarTodos();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void eliminar(Persona per) {
		try {
			dao.eliminar(per.getId());
			this.listar();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void registrar() {
		try {
			persona.setFoto(foto.getContents());
			if (persona.getId() > 0) {
				dao.actualizar(persona);
			} else {
				dao.agregar(persona);
			}
			this.listar();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void listarPorId(Persona per) {
		try {
			persona = dao.listarPorId(per.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void limpiarControles() {
		this.persona = new Persona();
	}

	/**
	 * getters & setters
	 */

	public List<Persona> getLista() {
		return lista;
	}

	public void setLista(List<Persona> lista) {
		this.lista = lista;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public UploadedFile getFoto() {
		return foto;
	}

	public void setFoto(UploadedFile foto) {
		this.foto = foto;
	}

}
