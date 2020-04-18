package com.clubprogramacionbarbaro.covidapi.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.clubprogramacionbarbaro.covidapi.dao.EquipamientoRepository;
import com.clubprogramacionbarbaro.covidapi.model.Equipamiento;
import com.clubprogramacionbarbaro.covidapi.service.EquipamientoService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EquipamientoServiceImpl implements EquipamientoService {

	private EquipamientoRepository repository;

	@Override
	public List<Equipamiento> findAllEquipamiento() {

		return repository.findAll();
	}

	@Override
	public Equipamiento findEquipamientoById(Integer equipamientoId) {

		return repository.findById(equipamientoId).get();
	}

	@Override
	public Equipamiento saveEquipamiento(Equipamiento equipamiento) {

		return repository.save(equipamiento);
	}

	@Override
	public Equipamiento updateEquipamiento(Integer equipamientoId, Equipamiento equipamiento) {

		Equipamiento equipamientoDB = findEquipamientoById(equipamientoId);
		equipamientoDB.setNombre(equipamiento.getNombre());
		equipamientoDB.setCantidad(equipamiento.getCantidad());
		equipamientoDB.setDescripcion(equipamiento.getDescripcion());
		equipamientoDB.setFechaCreacion(equipamiento.getFechaCreacion());
		equipamientoDB.setFechaVencimiento(equipamiento.getFechaVencimiento());

		return repository.save(equipamientoDB);
	}

	@Override
	public void deleteEquipamientoById(Integer equipamientoId) {

		repository.deleteById(equipamientoId);
	}
}
