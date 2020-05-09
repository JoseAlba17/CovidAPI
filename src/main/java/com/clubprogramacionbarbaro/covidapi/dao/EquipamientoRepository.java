package com.clubprogramacionbarbaro.covidapi.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clubprogramacionbarbaro.covidapi.model.Equipamiento;
import com.clubprogramacionbarbaro.covidapi.model.Hospital;

@Repository
public interface EquipamientoRepository extends JpaRepository<Equipamiento, Integer> {
	
	// SELECT * FROM equipamiento WHERE equipamientoId...
	List<Equipamiento> findByEquipamientoId(Integer equipamientoId);

	// SELECT * FROM equipamiento WHERE nombre...
	List<Equipamiento> findByNombre(String nombre);

	// SELECT * FROM equipamiento WHERE descripcion...
	List<Equipamiento> findByDescripcion(String descripcion);

	// SELECT * FROM equipamiento WHERE cantidad...
	List<Equipamiento> findByCantidad(Integer cantidad);
	
	// SELECT * FROM equipamiento WHERE fechaVencimiento...
	List<Equipamiento> findByFechaVencimiento(LocalDate fechaVencimiento);
	
	// SELECT * FROM hospital WHERE fechaActualizacion...
	List<Equipamiento> findByFechaActualizacion(Date fechaActualizacion);

	// SELECT * FROM equipamiento WHERE fechaCreacion...
	List<Equipamiento> findByFechaCreacion(LocalDateTime fechaCreacion);
	
}
