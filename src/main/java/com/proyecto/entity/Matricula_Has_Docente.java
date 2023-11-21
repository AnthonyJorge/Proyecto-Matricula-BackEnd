package com.proyecto.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "matricula_has_docente")
public class Matricula_Has_Docente {
	
	@EmbeddedId
	private Matricula_Has_Docente_PK matricula_has_docente_pk;

	@ManyToOne
	@JoinColumn(name = "idMatricula", nullable = false, insertable = false, updatable = false)
	private Matricula matricula;

	@ManyToOne
	@JoinColumn(name = "idDocente", nullable = false, insertable = false, updatable = false)
	private Docente docente;

}
