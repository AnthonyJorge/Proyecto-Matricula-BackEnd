package com.proyecto.service;

import java.util.List;

import com.proyecto.entity.Alumno;

public interface alumnoService {
	
	public abstract Alumno agregarAlumno(Alumno alumno);
	
	public abstract Alumno actualizarAlumno(Alumno alumno);
	
	public abstract List<Alumno> listarAlumnoPorNombre(String nombre);
	
	public abstract void eliminarAlumno(int idAlumno);
	
	public abstract List<Alumno> listarTodos();

}
