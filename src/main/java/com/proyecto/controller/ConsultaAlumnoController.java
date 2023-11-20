package com.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.entity.Alumno;
import com.proyecto.service.alumnoService;

@RestController
@RequestMapping("/url/consultaAlumno")
@CrossOrigin(origins ="http://localhost:4200")
public class ConsultaAlumnoController {
	@Autowired
	private alumnoService alsService;

	
	@GetMapping("/consultaAlumnoDinamica")
	@ResponseBody
	public List<Alumno> consultaAlumno( 
					@RequestParam(name = "nombre" , required = false, defaultValue = "") String nombre,
					@RequestParam(name = "apellidoPa" , required = false, defaultValue = "") String apellidoPa,
					@RequestParam(name = "dni" , required = false, defaultValue = "") String dni,
					@RequestParam(name = "idSexo" , required = false, defaultValue = "-1") int idSexo)
					{
	 return  alsService.ConsultaAlumno(nombre , apellidoPa,dni,idSexo);
		

	}
}
