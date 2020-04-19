package com.clubprogramacionbarbaro.covidapi.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "hospital")
@Data
public class Hospital {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "hospital_id")
	private Integer hospitalId;

	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "latitud")
	private Double latitud;
	
	@Column(name = "longitud")
	private Double longitud;
	
	@Column(name = "tipo_institucion")
	private String tipoInstitucion;
	
	@Column(name = "domicilio")
	private String domicilio;

	@Column(name = "fecha_creacion")
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime fechaCreacion;

}
