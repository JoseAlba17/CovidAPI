package com.clubprogramacionbarbaro.covidapi.service;

import java.util.List;

import com.clubprogramacionbarbaro.covidapi.model.Equipamiento;

public interface EquipamientoService {

	List<Equipamiento> findAllEquipamiento();

	Equipamiento findEquipamientoById(Integer equipamientoId);

	Equipamiento saveEquipamiento(Equipamiento equipamiento);

	Equipamiento updateEquipamiento(Integer equipamientoId, Equipamiento equipamiento);

	void deleteEquipamientoById(Integer equipamientoId);

}