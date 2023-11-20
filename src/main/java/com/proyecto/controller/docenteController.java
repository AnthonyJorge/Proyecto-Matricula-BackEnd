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

import com.proyecto.entity.Docente;
import com.proyecto.service.docenteService;
import com.proyecto.utils.Mensajes;
import com.proyecto.utils.Utils;

@RestController
@RequestMapping("/url/crudDocente")
@CrossOrigin(originPatterns ="http://localhost:4200")
public class docenteController {

	@Autowired
	private docenteService doService;

	

	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Docente>> listarDocente() {
		List<Docente> listado = doService.listarTodos();
		return ResponseEntity.ok(listado);
	}

	@PostMapping
	@ResponseBody
	public ResponseEntity<?> insertarDocente(@RequestBody Docente obj) {
		HashMap<String, Object> salida = new HashMap<>();
		List<Docente> validarDocente = doService.listarTodos();

		obj.setFechaRegistro(new Date());

		if (validarDocente.stream().anyMatch(a -> a.getDni().equals(obj.getDni()))) {
			salida.put("mensaje", Mensajes.MENSAJE_DNI_YA_EXISTE + obj.getDni());
		} else {
			Docente objSalida = doService.agregarDocente(obj);
			if (objSalida == null) {
				salida.put("mensaje", Mensajes.MENSAJE_REG_ERROR);

			} else {
				salida.put("mensaje", Mensajes.MENSAJE_REG_EXITOSO);
			}
		}

		return ResponseEntity.ok(salida);
	}

	@PutMapping("/actualizarDocente")
	@ResponseBody
	public ResponseEntity<?> actualizarDocente(@RequestBody Docente obj) {
		HashMap<String, Object> salida = new HashMap<>();
		List<Docente> validarDocente = doService.listarTodos();

		obj.setFechaRegistro(new Date());
		if (validarDocente.stream()
				.anyMatch(c -> c.getDni().equals(obj.getDni()) && c.getIdDocente() != obj.getIdDocente())) {
			salida.put("mensaje", Mensajes.MENSAJE_DNI_YA_EXISTE + obj.getDni());
		} else {

			Docente objSlida = doService.actualizarDocentes(obj);
			if (objSlida == null) {
				salida.put("mensaje", Mensajes.MENSAJE_ACT_ERROR);
			} else {
				salida.put("mensaje", Mensajes.MENSAJE_ACT_EXITOSO);
			}
		}
		return ResponseEntity.ok(salida);

	}

	@DeleteMapping("/eliminarDocente/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> eliminarDocente(@PathVariable("id") int idDocente) {
		Map<String, Object> salida = new HashMap<>();

		try {
			doService.eliminarDocente(idDocente);
			salida.put("mensaje", Mensajes.MENSAJE_ELI_EXITOSO);

		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Mensajes.MENSAJE_ELI_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
}
