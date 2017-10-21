package com.mitocode.dao;

import java.util.List;

import com.mitocode.model.Telefono;

public interface TelefonoDAO {

	void registrar(List<Telefono> lstTelefonos) throws Exception;
	List<Telefono> listar() throws Exception;
}
