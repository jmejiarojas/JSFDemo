package com.mitocode.dao;

import java.util.List;

import com.mitocode.model.Ubigeo;

public interface UbigeoDAO {

	List<Ubigeo> listarPaises() throws Exception;
	List<Ubigeo> listarRegiones(int codPais) throws Exception;
	List<Ubigeo> listarProvincias(int codPais, int codRegion) throws Exception;
}
