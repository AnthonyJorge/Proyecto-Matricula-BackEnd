package com.proyecto.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.entity.Alumno;
import com.proyecto.entity.Docente;
import com.proyecto.entity.Matricula;
import com.proyecto.service.alumnoService;
import com.proyecto.service.docenteService;
import com.proyecto.service.matriculaService;


@RestController
@RequestMapping("/url/crudMatricula")
@CrossOrigin(originPatterns = "http://localhost:4200")
public class matriculaController {
	
	@Autowired
	private matriculaService maService;
	
	@Autowired
	private docenteService doService;
	
	@Autowired
	private alumnoService alService;
	
	@ResponseBody
	@GetMapping("/listaBoletas")
	public List<Matricula> lista() {
		List<Matricula> lstBoletas = maService.listarTodo();
		return lstBoletas; 
	}


	@ResponseBody
	@PostMapping("/registrarMatricula")
	public HashMap<String, Object> registraBoleta(@RequestBody  Matricula objMatricula) {
		
		HashMap<String, Object> mapSalida = new HashMap<String, Object>();
		objMatricula.setFechaRegistro(new Date());
		Matricula objMatriculaSalida = maService.agregarMatricula(objMatricula);
		if (objMatriculaSalida != null) {
			mapSalida.put("mensaje", "Se registró la Matricula " + objMatriculaSalida.getIdMatricula());
			mapSalida.put("data", objMatriculaSalida);
		}else {
			mapSalida.put("mensaje", "No se registró la Matricula, consulte al administardor");
		}
		return mapSalida; 
	}
	
	
	//Docente
	@ResponseBody
	@GetMapping("/listaDocente")
	public List<Docente> listaDocente(
			@RequestParam(name = "page", defaultValue = "0", required = false) int page,
			@RequestParam(name = "size", defaultValue = "5", required = false) int size) {
		Pageable paginacion = PageRequest.of(page, size);
		List<Docente> lista = doService.listaDocenteFiltro("%",paginacion);
		return lista;
	}
	
	@ResponseBody
	@GetMapping("/listaDocente/{filtro}")
	public List<Docente> listaDocente(@PathVariable("filtro") String filtro,
			@RequestParam(name = "page", defaultValue = "0", required = false) int page,
			@RequestParam(name = "size", defaultValue = "5", required = false) int size) {
		Pageable paginacion = PageRequest.of(page, size);
		List<Docente> lista = doService.listaDocenteFiltro(filtro + "%", paginacion);
		return lista;
	}
	
	//Alumnos
	@ResponseBody
	@GetMapping("/listaAlumno")
	public List<Alumno> listaAlumno(
			@RequestParam(name = "page", defaultValue = "0", required = false) int page,
			@RequestParam(name = "size", defaultValue = "5", required = false) int size) {
		Pageable paginacion = PageRequest.of(page, size);
		List<Alumno> lista = alService.listaAlumnoFiltro("%", paginacion);
		return lista;
	}
	
	@ResponseBody
	@GetMapping("/listaAlumno/{filtro}")
	public List<Alumno> listaAlumno(@PathVariable("filtro") String filtro,
			@RequestParam(name = "page", defaultValue = "0", required = false) int page,
			@RequestParam(name = "size", defaultValue = "5", required = false) int size) {
		Pageable paginacion = PageRequest.of(page, size);
		List<Alumno> lista = alService.listaAlumnoFiltro(filtro + "%", paginacion);
		return lista;
	}
	
	
	
}
