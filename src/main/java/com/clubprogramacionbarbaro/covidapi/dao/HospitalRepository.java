package com.clubprogramacionbarbaro.covidapi.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clubprogramacionbarbaro.covidapi.model.Hospital;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Integer> {

	// SELECT * FROM hospital WHERE hospitalId...
	List<Hospital> findByHospitalId(Integer hospitalId);

	// SELECT * FROM hospital WHERE nombre...
	List<Hospital> findByNombre(String nombre);

	// SELECT * FROM hospital WHERE tipoInstitucion...
	List<Hospital> findByTipoInstitucion(String tipoInstitucion);

	// SELECT * FROM hospital WHERE domicilio...
	List<Hospital> findByDomicilio(String domicilio);

	// SELECT * FROM hospital WHERE fechaCreacion...
	List<Hospital> findByFechaCreacion(Date fechaCreacion);
	
	// SELECT * FROM hospital WHERE fechaActualizacion...
	List<Hospital> findByFechaActualizacion(Date fechaActualizacion);

	// SELECT * FROM hospital WHERE latitud AND logitud...
	List<Hospital> findByLatitudAndLongitud(Double latitud, Double longitud);

}
