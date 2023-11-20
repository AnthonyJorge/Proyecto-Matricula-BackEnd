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

import com.proyecto.entity.Alumno;
import com.proyecto.service.alumnoService;
import com.proyecto.utils.Mensajes;

@RestController
@RequestMapping("/url/crudAlumno")
@CrossOrigin(origins ="http://localhost:4200")
public class alumnoController {
	

	@Autowired
	private alumnoService alService;

	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Alumno>> listarAlumno(){
		List<Alumno> listado = alService.listarTodos();
		return ResponseEntity.ok(listado);
	}

	@PostMapping
	@ResponseBody
	public ResponseEntity<?> insertarAlumno(@RequestBody Alumno obj) {
		HashMap<String, Object> salida = new HashMap<>();
		List<Alumno> validarAlumno = alService.listarTodos();

		
		obj.setFechaRegistro(new Date());

		if (validarAlumno.stream()
				.anyMatch(c -> c.getDni().equals(obj.getDni()))) {
			salida.put("mensaje", Mensajes.MENSAJE_DNI_YA_EXISTE + obj.getDni());
		} else {
			Alumno objSalida = alService.agregarAlumno(obj);
			if (objSalida == null) {
				salida.put("mensaje", Mensajes.MENSAJE_REG_ERROR);

			} else {
				salida.put("mensaje", Mensajes.MENSAJE_REG_EXITOSO);
			}
		}

		return ResponseEntity.ok(salida);
	}

	@PutMapping("/actualizarAlumno")
	@ResponseBody
	public ResponseEntity<?> actualizarAlumno(@RequestBody Alumno obj) {
		HashMap<String, Object> salida = new HashMap<>();
		List<Alumno> validarCurso = alService.listarTodos();

		obj.setFechaRegistro(new Date());
		if (validarCurso.stream()
				.anyMatch(a -> a.getDni().equals(obj.getDni()) && a.getIdAlumno() != obj.getIdAlumno())) {
			salida.put("mensaje", Mensajes.MENSAJE_DNI_YA_EXISTE + obj.getDni());
		} else {

			Alumno objSlida = alService.actualizarAlumno(obj);
			if (objSlida == null) {
				salida.put("mensaje", Mensajes.MENSAJE_ACT_ERROR);
			} else {
				salida.put("mensaje", Mensajes.MENSAJE_ACT_EXITOSO);
			}
		}
		return ResponseEntity.ok(salida);

	}

	@DeleteMapping("/eliminarAlumno/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> eliminarAlumno(@PathVariable("id") int idAlumno) {
		Map<String, Object> salida = new HashMap<>();

		try {
			alService.eliminarAlumno(idAlumno);
			salida.put("mensaje", Mensajes.MENSAJE_ELI_EXITOSO);

		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Mensajes.MENSAJE_ELI_ERROR);
		}
		return ResponseEntity.ok(salida);
	}

}
