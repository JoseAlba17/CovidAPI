package com.clubprogramacionbarbaro.covidapi.web.rest.resource;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.clubprogramacionbarbaro.covidapi.model.Equipamiento;
import com.clubprogramacionbarbaro.covidapi.service.EquipamientoService;
import com.clubprogramacionbarbaro.covidapi.web.rest.util.EquipamientoConstants;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = EquipamientoConstants.GLOBAL_CONTEXT_PATH)
@AllArgsConstructor
public class EquipamientoResource {

	private EquipamientoService equipamientoService;

	@GetMapping(path = EquipamientoConstants.FIND_ALL_EQUIPAMIENTO)
	public ResponseEntity<List<Equipamiento>> findAllEquipamientos() {
		List<Equipamiento> equipamientos = equipamientoService.findAllEquipamiento();

		return new ResponseEntity<>(equipamientos, HttpStatus.OK);
	}

	@GetMapping(path = EquipamientoConstants.FIND_EQUIPAMIENTO_BY_ID)
	public ResponseEntity<Equipamiento> findEquipamientoById(@RequestParam("Id") Integer equipamientoId) {
		Equipamiento equipamiento = equipamientoService.findEquipamientoById(equipamientoId);

		return new ResponseEntity<>(equipamiento, HttpStatus.FOUND);
	}

	@PostMapping(path = EquipamientoConstants.SAVE_EQUIPAMIENTO)
	public ResponseEntity<Equipamiento> saveEquipamiento(@RequestBody Equipamiento equipamientoRequest) {
		Equipamiento equipamientoResponse = equipamientoService.saveEquipamiento(equipamientoRequest);

		return new ResponseEntity<>(equipamientoResponse, HttpStatus.CREATED);
	}
	
	@PutMapping(path = EquipamientoConstants.UPDATE_EQUIPAMIENTO)
	public ResponseEntity<Equipamiento> updateEquipamiento(@RequestParam("Id") Integer equipamientoId, @RequestBody Equipamiento equipamientoRequest){
		Equipamiento EquipamientoResponse = equipamientoService.updateEquipamiento(equipamientoId, equipamientoRequest);

		return new ResponseEntity<>(EquipamientoResponse, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping(path = EquipamientoConstants.DELETE_EQUIPAMIENTO_BY_ID)
	public ResponseEntity<Equipamiento> deleteEquipamientoById(@RequestParam("Id") Integer equipamientoId) {
		equipamientoService.deleteEquipamientoById(equipamientoId);

		return new ResponseEntity<>(HttpStatus.OK);
	}
}
