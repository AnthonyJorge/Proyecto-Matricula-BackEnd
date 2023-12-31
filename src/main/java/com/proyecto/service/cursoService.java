package com.proyecto.service;

import java.util.List;

import com.proyecto.entity.Curso;

public interface cursoService {
	
	public abstract Curso agregarCurso(Curso curso);

	public abstract Curso actualizarCurso(Curso curso);
		
	public abstract void eliminarDocente(int idCurso);

	public abstract List<Curso> listarTodos();
	
	//consultar
	
	public abstract  List<Curso> consultaCurso(String nombre, int idGrado);
	
}
