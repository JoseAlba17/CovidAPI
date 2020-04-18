package com.clubprogramacionbarbaro.covidapi.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Table(name = "equipamiento")
@Data
public class Equipamiento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer equipamientoId;
	
	private String nombre;
	private String descripcion;
	private Integer cantidad;
	private LocalDate fechaVencimiento;
	
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime fechaCreacion;

}