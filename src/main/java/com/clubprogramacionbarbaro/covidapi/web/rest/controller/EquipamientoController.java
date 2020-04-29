package com.clubprogramacionbarbaro.covidapi.web.rest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clubprogramacionbarbaro.covidapi.model.Equipamiento;
import com.clubprogramacionbarbaro.covidapi.model.Hospital;
import com.clubprogramacionbarbaro.covidapi.service.EquipamientoService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/${api.version}/equipamiento")
@AllArgsConstructor
public class EquipamientoController {

	private EquipamientoService service;

	@GetMapping
	public ResponseEntity<List<Equipamiento>> findAllEquipamiento() {

		return new ResponseEntity<>(service.findAllEquipamiento(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Equipamiento> findEquipamientoById(@PathVariable("id") Integer id) {

		return new ResponseEntity<>(service.findEquipamientoById(id), HttpStatus.FOUND);
	}

	@PostMapping
	public ResponseEntity<Equipamiento> saveEquipamiento(@RequestBody Equipamiento equipamiento) {

		return new ResponseEntity<>(service.saveEquipamiento(equipamiento), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Equipamiento> updateEquipamiento(@PathVariable("id") Integer id,
			@RequestBody Equipamiento equipamiento) {

		return new ResponseEntity<>(service.updateEquipamiento(id, equipamiento), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Equipamiento> deleteEquipamiento(@PathVariable("id") Integer id) {
		service.deleteEquipamientoById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("/{id}/hospitales")
	public ResponseEntity<Equipamiento> addHospitalToEquipamiento(@PathVariable("id") Integer equipamientoId,
			@RequestBody Hospital hospital) {
		return new ResponseEntity<>(service.addHospitalToEquipamiento(equipamientoId, hospital.getHospitalId()), HttpStatus.OK);
	}
}
