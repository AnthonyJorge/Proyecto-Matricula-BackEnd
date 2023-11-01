package com.proyecto.service;

import java.util.List;

import com.proyecto.entity.Matricula;

public interface matriculaService {
	
	public abstract Matricula agregarMatricula(Matricula matricula);
	
	public abstract Matricula actualizarMatricula(Matricula matricula);
	
	public abstract void eliminarMatricula(int idMatricula);
	
	public abstract List<Matricula> listarTodo();
	


}
