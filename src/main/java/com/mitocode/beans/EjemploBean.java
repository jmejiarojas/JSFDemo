package com.mitocode.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.mitocode.dao.UbigeoDAO;
import com.mitocode.dao.UbigeoDAOImpl;
import com.mitocode.model.Ubigeo;

@ManagedBean
@ViewScoped
public class EjemploBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String nombre;
	private int codigoPais;
	private int codigoRegion;
	private List<Ubigeo> lstPaises;
	private List<Ubigeo> lstRegiones;
	private List<Ubigeo> lstProvincias;
	private UbigeoDAO ubigeoDAO;

	public EjemploBean() {
		lstPaises = new ArrayList<>();
		ubigeoDAO = new UbigeoDAOImpl();
		this.listarPaises();
	}

	public void listarPaises() {
		try {
			lstPaises = ubigeoDAO.listarPaises();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void listarRegiones() {
		try {
			lstRegiones = ubigeoDAO.listarRegiones(codigoPais);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void listarProvincias() {
		try {
			lstProvincias = ubigeoDAO.listarProvincias(codigoPais, codigoRegion);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * getters & setters
	 * 
	 */

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Ubigeo> getLstPaises() {
		return lstPaises;
	}

	public void setLstPaises(List<Ubigeo> lstPaises) {
		this.lstPaises = lstPaises;
	}

	public int getCodigoPais() {
		return codigoPais;
	}

	public void setCodigoPais(int codigoPais) {
		this.codigoPais = codigoPais;
	}

	public List<Ubigeo> getLstRegiones() {
		return lstRegiones;
	}

	public void setLstRegiones(List<Ubigeo> lstRegiones) {
		this.lstRegiones = lstRegiones;
	}

	public int getCodigoRegion() {
		return codigoRegion;
	}

	public void setCodigoRegion(int codigoRegion) {
		this.codigoRegion = codigoRegion;
	}

	public List<Ubigeo> getLstProvincias() {
		return lstProvincias;
	}

	public void setLstProvincias(List<Ubigeo> lstProvincias) {
		this.lstProvincias = lstProvincias;
	}

}
