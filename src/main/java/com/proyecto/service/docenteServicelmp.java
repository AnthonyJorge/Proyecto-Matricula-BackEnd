package com.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.Interface.docenteRepository;
import com.proyecto.entity.Docente;

@Service
public class docenteServicelmp implements docenteService{

	@Autowired
	private docenteRepository rpy;
	
	@Override
	public Docente agregarDocente(Docente docente) {
		return rpy.save(docente);
	}

	@Override
	public Docente actualizarDocentes(Docente docente) {
		return rpy.save(docente);
	}

	@Override
	public void eliminarDocente(int idDocente) {
		rpy.deleteById(idDocente);
	}

	@Override
	public List<Docente> listarTodos() {
		return rpy.findAll();
	}

	@Override
	public List<Docente> consultaDocente(String nombre, String apellidoPa, String dni, int idSexo, int idCurso) {
		return rpy.consultaDinamica(nombre, apellidoPa, dni, idSexo, idCurso);
	}

	
	
	
	

}
