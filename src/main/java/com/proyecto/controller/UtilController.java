package com.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.entity.Grado;
import com.proyecto.entity.Sexo;

import com.proyecto.service.gradoService;
import com.proyecto.service.sexoService;


@RestController
@RequestMapping("/url/util")
@CrossOrigin(origins = "http://localhost:4200")
public class UtilController {
	
	@Autowired
	private gradoService gdService;
	
	@Autowired
	private sexoService seService;
	

	@GetMapping("/listarGrado")
	@ResponseBody
	public List<Grado>listarGrado(){
		
		return gdService.listarGrados();
		
	}
	
	@GetMapping("/listarSexo")
	@ResponseBody
	public List<Sexo>listarSexo(){
		
		return seService.listaTodos();
		
	}
	
	

}
