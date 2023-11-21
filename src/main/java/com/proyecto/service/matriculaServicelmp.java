package com.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.Interface.matriculaRepository;
import com.proyecto.Interface.matricula_has_docente;
import com.proyecto.entity.Matricula;
import com.proyecto.entity.Matricula_Has_Docente;

import jakarta.transaction.Transactional;

@Service
public class matriculaServicelmp implements matriculaService {

	@Autowired
	private matriculaRepository rpy;
	
	@Autowired
	private matricula_has_docente detalle_rpy;
	@Override
	@Transactional
	public Matricula agregarMatricula(Matricula obj) {
		Matricula cabecera = rpy.save(obj);
		
		for (Matricula_Has_Docente d : cabecera.getDetallesMatricula()) {
			d.getMatricula_has_docente_pk().setIdMatricula(cabecera.getIdMatricula());
			d.getMatricula_has_docente_pk().getIdDocente();
			detalle_rpy.save(d);
		}
		return cabecera;
	}


	@Override
	public List<Matricula> listarTodo() {
		return rpy.findAll();
	}



}
