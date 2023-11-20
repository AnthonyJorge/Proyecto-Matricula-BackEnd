package com.proyecto.service;

import java.util.List;

import com.proyecto.entity.Docente;

public interface docenteService {
	
	public abstract Docente agregarDocente(Docente docente);

	public abstract Docente actualizarDocentes(Docente docente);
	
	public abstract void eliminarDocente(int idDocente);
	
	public abstract List<Docente> listarTodos();
	
	//consultas
	public abstract List<Docente> consultaDocente(String nombre, String apellidoPa,String dni, int idSexo,int idCurso);

}
