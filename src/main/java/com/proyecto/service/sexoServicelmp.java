package com.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.Interface.sexoRepository;
import com.proyecto.entity.Sexo;

@Service
public class sexoServicelmp  implements sexoService{

	@Autowired
	private sexoRepository rpy;
	
	@Override
	public List<Sexo> listaTodos() {
		return rpy.findAll();
	}

}
