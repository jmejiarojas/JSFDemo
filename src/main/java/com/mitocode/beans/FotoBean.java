package com.mitocode.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.UploadedFile;

import com.mitocode.dao.PersonaDAO;
import com.mitocode.dao.PersonaDAOImpl;
import com.mitocode.model.Persona;

@ManagedBean
@SessionScoped
public class FotoBean {

	private UploadedFile foto;
	private PersonaDAO dao;
	private Persona persona;
	private int idPersona;	

	public FotoBean() {
		dao = new PersonaDAOImpl();
	}

	public void cargarFoto() throws Exception {
		persona = dao.listarPorId(idPersona);
	}

	public UploadedFile getFoto() {
		return foto;
	}

	public void setFoto(UploadedFile foto) {
		this.foto = foto;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}
	
	

}
