package com.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.Interface.cursoRepository;
import com.proyecto.entity.Curso;

@Service
public class cursoServicelmp implements cursoService{
	@Autowired
	private  cursoRepository rpy;
	
	@Override
	public Curso agregarCurso(Curso curso) {
		return rpy.save(curso);
	}

	@Override
	public List<Curso> listaCursoPorNombre(String nombre) {
		return rpy.listaPorNombre(nombre);
		}

	@Override
	public void eliminarDocente(int idCurso) {
		rpy.deleteById(idCurso);
	}

	@Override
	public Curso ActualizarCurso(Curso curso) {
		return rpy.save(curso);
	}

	@Override
	public List<Curso> listarTodos() {
		return rpy.findAll();
	}
}
