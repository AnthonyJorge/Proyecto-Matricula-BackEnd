package com.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.Interface.alumnoRepository;
import com.proyecto.entity.Alumno;

@Service
public class alumnoServicelmp implements alumnoService{

	@Autowired
	private alumnoRepository rpy;
	
	@Override
	public Alumno agregarAlumno(Alumno alumno) {
		return rpy.save(alumno);
	}

	@Override
	public Alumno actualizarAlumno(Alumno alumno) {
		return rpy.save(alumno);
	}

	@Override
	public void eliminarAlumno(int idAlumno) {
		rpy.deleteById(idAlumno);
	}

	@Override
	public List<Alumno> listarTodos() {
		return rpy.findAll();
	}

	@Override
	public List<Alumno> ConsultaAlumno(String nombre, String apellidoPa, String dni, int idSexo) {
		return rpy.consultaDinamica(nombre, apellidoPa, dni, idSexo);
	}



	

}
