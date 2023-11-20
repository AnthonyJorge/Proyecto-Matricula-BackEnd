package com.proyecto.service;

import java.util.List;

import com.proyecto.entity.Alumno;

public interface alumnoService {
	
	public abstract Alumno agregarAlumno(Alumno alumno);
	
	public abstract Alumno actualizarAlumno(Alumno alumno);
	
	public abstract void eliminarAlumno(int idAlumno);
	
	public abstract List<Alumno> listarTodos();
	
	//consulta

	public abstract List<Alumno> ConsultaAlumno(String nombre, String apellidoPa,String dni, int idSexo);


}
