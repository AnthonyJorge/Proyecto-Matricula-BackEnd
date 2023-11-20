package com.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.proyecto.entity.Docente;
import com.proyecto.service.docenteService;

@RestController
@RequestMapping("/url/consultaDocente")
@CrossOrigin(origins ="http://localhost:4200")
public class ConsultaDocenteController {

	@Autowired
	private docenteService doService;
	
	@GetMapping("/consultaDocenteDinamica")
	@ResponseBody
	public List<Docente> consultaAlumno( 
					@RequestParam(name = "nombre" , required = false, defaultValue = "") String nombre,
					@RequestParam(name = "apellidoPa" , required = false, defaultValue = "") String apellidoPa,
					@RequestParam(name = "dni" , required = false, defaultValue = "") String dni,
					@RequestParam(name = "idSexo" , required = false, defaultValue = "-1") int idSexo,
					@RequestParam(name = "idCurso" , required = false, defaultValue = "-1") int idCurso)
					{
	 return  doService.consultaDocente(nombre , apellidoPa,dni,idSexo,idCurso);
		

	}
}
