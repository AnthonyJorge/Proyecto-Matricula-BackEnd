package com.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.entity.Matricula;
import com.proyecto.service.matriculaService;

@RestController
@RequestMapping("/url/consultaMatricula")
@CrossOrigin(originPatterns = "http://localhost:4200")
public class ConsultaMatriculaController {
	@Autowired
	private matriculaService maService;
	
	
}
