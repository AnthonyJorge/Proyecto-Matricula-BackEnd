package com.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.entity.Grado;
import com.proyecto.service.gradoService;
import com.proyecto.utils.Utils;

@RestController
@RequestMapping("/url/util")
@CrossOrigin(origins = Utils.URL_CROSS_ORIGIN)
public class UtilController {
	
	@Autowired
	private gradoService gdService;
	
	@GetMapping("/listarGrado")
	@ResponseBody
	public List<Grado>listarGrado(){
		
		return gdService.listarGrados();
		
	}

}
