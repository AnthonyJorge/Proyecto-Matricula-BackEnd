package com.proyecto.controller;

import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.entity.Curso;
import com.proyecto.service.cursoService;
import com.proyecto.utils.Utils;

@RestController
@RequestMapping("/url/curso")
@CrossOrigin(origins = Utils.URL_CROSS_ORIGIN)
public class cursoController {
	
	@Autowired
	private cursoService cuService;
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<?> insertarCurso(@RequestBody Curso obj){
		HashMap<String, Object> salida = new HashMap<>();
		
		obj.setFechaRegistro(new Date());
		
		Curso objSalida = cuService.agregarCurso(obj);
		
		if (objSalida == null) {
			salida.put("mensaje","Error en el registro");
		}else {
			salida.put("mensaje","Se registró el Curso con el ID ==> " + objSalida.getIdCurso());
		}
		return ResponseEntity.ok(salida);
	}
		
	}
	

