package com.proyecto.entity;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class Matricula_Has_Docente_PK {
	
	private static final long serialVersionUID = 1L;
	private int idMatricula;
	private int idDocente;
}
