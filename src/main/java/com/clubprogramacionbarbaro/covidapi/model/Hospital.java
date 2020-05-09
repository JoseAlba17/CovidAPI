package com.clubprogramacionbarbaro.covidapi.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@Table(name = "hospital")
@Data
@ApiModel(description = "All details about Hospital")
public class Hospital {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer hospitalId;

	@ApiModelProperty(notes = "Nombre should have at least 15 characters")
	private String nombre;

	@ApiModelProperty(notes = "latitud should not be blank")
	private Double latitud;

	@ApiModelProperty(notes = "longitud should not be blank")
	private Double longitud;

	@ApiModelProperty(notes = "tipoInstitucion should have at least 15 characters")
	private String tipoInstitucion;

	@ApiModelProperty(notes = "Domicilio should have at least 15 characters")
	private String domicilio;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaActualizacion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCreacion;

	@OneToMany(targetEntity = Equipamiento.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "hospitalId", referencedColumnName = "hospitalId")
	private List<Equipamiento> equipamientos;

	@ManyToMany(mappedBy = "hospitales")
	private List<Enlace> enlaces;
}
