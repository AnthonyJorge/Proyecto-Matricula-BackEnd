package com.proyecto.Interface;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.entity.Alumno;

public interface alumnoRepository extends JpaRepository<Alumno, Integer> {

}
