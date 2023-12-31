package com.proyecto.Interface;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.proyecto.entity.Docente;

public interface docenteRepository extends JpaRepository<Docente, Integer> {

	
	@Query("select x from Docente x where x.nombre like %?1% and "
			+ "x.apellidoPa like %?2% and "
			+ "x.dni like %?3% and "
			+ "(?4 = -1 or sexo.idSexo = ?4) and "
			+ "(?5 = -1 or curso.idCurso = ?5)")
	public List<Docente> consultaDinamica(String nombre, String apellidoPa,String dni, int idSexo,int idCurso);
	
	@Query("Select x from Docente x where dni like :var_filtro")
	public  List<Docente> listaDocente(@Param("var_filtro") String filtro, Pageable ageable);
}
