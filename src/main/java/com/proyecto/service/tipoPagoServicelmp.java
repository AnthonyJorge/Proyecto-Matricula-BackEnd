package com.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.Interface.TipoPagoRepositoty;
import com.proyecto.entity.TipoPago;

@Service
public class tipoPagoServicelmp implements tipoPagoService{

	@Autowired
	private TipoPagoRepositoty rpy;
	
	@Override
	public List<TipoPago> listarTodo() {
		return rpy.findAll();
	}

}
