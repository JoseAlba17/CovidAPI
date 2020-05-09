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
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@Table(name = "equipamiento")
@Data
@ApiModel(description = "All details about Equipamiento")
public class Equipamiento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer equipamientoId;

	@Column(nullable = true)
	private Integer hospitalId; // Llave foránea

	@ApiModelProperty(notes = "Should have at least 15 characters")
	private String nombre;

	@ApiModelProperty(notes = "Should have at least 15 characters")
	private String descripcion;

	@ApiModelProperty(notes = "Cantidad should have at least 15 characters")
	private Integer cantidad;

	@Temporal(TemporalType.DATE)
	@ApiModelProperty(notes = "fechaVencimiento should be a future date")
	private Date fechaVencimiento;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaActualizacion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCreacion;

}