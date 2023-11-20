package com.proyecto.Interface;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyecto.entity.Curso;

public interface cursoRepository extends JpaRepository<Curso, Integer>{

	@Query("select x from Curso x where x.nombre like %?1% and "
			+ "(?2 = -1 or grado.idGrado = ?2)")
	public List<Curso> consultaDinamica(String nombre, int idGrado);
	
}
