package com.proyecto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.Interface.cursoRepository;
import com.proyecto.entity.Curso;

@Service
public class cursoServicelmp implements cursoService{
	@Autowired
	private  cursoRepository rpy;
	
	@Override
	public Curso agregarCurso(Curso obj) {
		return rpy.save(obj);
	}
	
	
	
	

}
