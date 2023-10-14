package com.proyecto.Interface;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.entity.Docente;

public interface docenteRepository extends JpaRepository<Docente, Integer> {

}
