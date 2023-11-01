package com.proyecto.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.entity.Matricula;
import com.proyecto.service.matriculaService;
import com.proyecto.utils.Mensajes;
import com.proyecto.utils.Utils;

@RestController
@RequestMapping("/url/crudMatricula")
@CrossOrigin(originPatterns = "http://localhost:4200")
public class matriculaController {
	@Autowired
	private matriculaService maService;

	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Matricula>> listarDocente() {
		List<Matricula> listado = maService.listarTodo();
		return ResponseEntity.ok(listado);
	}

	@PostMapping
	@ResponseBody
	public ResponseEntity<?> insertarDocente(@RequestBody Matricula obj) {
		HashMap<String, Object> salida = new HashMap<>();
	

		obj.setFechaRegistro(new Date());

			Matricula objSalida = maService.agregarMatricula(obj);
			if (objSalida == null) {
				salida.put("mensaje", Mensajes.MENSAJE_REG_ERROR);

			} else {
				salida.put("mensaje", Mensajes.MENSAJE_REG_EXITOSO);
			}
	

		return ResponseEntity.ok(salida);
	}

	@PutMapping("/actualizarMatricula")
	@ResponseBody
	public ResponseEntity<?> actualizarMatricula(@RequestBody Matricula obj) {
		HashMap<String, Object> salida = new HashMap<>();
	

		obj.setFechaRegistro(new Date());
		
			Matricula objSlida = maService.actualizarMatricula(obj);
			if (objSlida == null) {
				salida.put("mensaje", Mensajes.MENSAJE_ACT_ERROR);
			} else {
				salida.put("mensaje", Mensajes.MENSAJE_ACT_EXITOSO);
			}

		return ResponseEntity.ok(salida);

	}

	@DeleteMapping("/eliminarMatricula/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> eliminarMatricula(@PathVariable("id") int idAlumno) {
		Map<String, Object> salida = new HashMap<>();

		try {
			maService.eliminarMatricula(idAlumno);
			salida.put("mensaje", Mensajes.MENSAJE_ELI_EXITOSO);

		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Mensajes.MENSAJE_ELI_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
}
