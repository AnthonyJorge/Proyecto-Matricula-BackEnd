package com.proyecto.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter


@Entity
@Table(name="tipoPago")
public class TipoPago {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTipoPago;
	private String nombre;
}
