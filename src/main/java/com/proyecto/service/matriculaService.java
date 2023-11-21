package com.proyecto.service;

import java.util.List;

import com.proyecto.entity.Matricula;

public interface matriculaService {
	
	public  Matricula agregarMatricula(Matricula obj);
	
	public abstract List<Matricula> listarTodo();
	


}
