package com.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.Interface.turnoRepository;
import com.proyecto.entity.Turno;

@Service
public class turnoServicelmp implements turnoService {

	@Autowired
	private turnoRepository rpy;
	
	@Override
	public List<Turno> listarTodos() {
		// TODO Auto-generated method stub
		return rpy.findAll();
	}

}
