package com.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.proyecto.entity.Curso;
import com.proyecto.service.cursoService;

@RestController
@RequestMapping("/url/consultaCurso")
@CrossOrigin(origins ="http://localhost:4200")
public class ConsultaCursoController {

	@Autowired
	private cursoService cuService;
	
	@GetMapping("/consultaCursoPorParametros")
	@ResponseBody
	public List<Curso> consultaAlumno( 
					@RequestParam(name = "nombre" , required = false, defaultValue = "") String nombre,
					@RequestParam(name = "idGrado" , required = false, defaultValue = "-1") int idGrado)
					{
	 return  cuService.consultaCurso(nombre ,idGrado);
		

	}
}
