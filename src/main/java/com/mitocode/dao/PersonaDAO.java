package com.mitocode.dao;

import java.util.List;

import com.mitocode.model.Persona;

public interface PersonaDAO {

	public void agregar(Persona Persona) throws Exception;

	public void eliminar(int PersonaId) throws Exception;

	public void actualizar(Persona Persona) throws Exception;

	public List<Persona> listarTodos() throws Exception;

	public Persona listarPorId(int id) throws Exception;

}
