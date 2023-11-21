package com.proyecto.Interface;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.proyecto.entity.Alumno;


public interface alumnoRepository extends JpaRepository<Alumno, Integer> {

	@Query("select x from Alumno x where x.nombre like %?1% and "
			+ "x.apellidoPa like %?2% and "
			+ "x.dni like %?3% and "
			+ "(?4 = -1 or sexo.idSexo = ?4)")
	public List<Alumno> consultaDinamica(String nombre, String apellidoPa,String dni, int idSexo);
	
	@Query("Select x from Alumno x where dni like :var_filtro")
	public  List<Alumno> listaAlumno(@Param("var_filtro") String filtro, Pageable ageable);
	
}
