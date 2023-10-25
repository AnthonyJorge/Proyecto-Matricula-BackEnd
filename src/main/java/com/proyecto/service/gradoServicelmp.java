package com.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.Interface.gradoRepository;
import com.proyecto.entity.Grado;

@Service
public class gradoServicelmp implements gradoService{

	@Autowired
	private gradoRepository rpyGrado;
	
	@Override
	public List<Grado> listarGrados() {
		return rpyGrado.findAll();
	}

}
