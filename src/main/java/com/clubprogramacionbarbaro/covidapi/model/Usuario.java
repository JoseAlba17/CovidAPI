package com.clubprogramacionbarbaro.covidapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Table(name = "usuario")
@Data
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer usuarioId;
	
	@Column(unique = true)
	private String email;
	private String contrasena;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaActualizacion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCreacion;
}
