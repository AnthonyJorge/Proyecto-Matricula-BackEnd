package com.proyecto.Interface;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyecto.entity.Matricula;

public interface matriculaRepository extends JpaRepository<Matricula, Integer>{
	
}
