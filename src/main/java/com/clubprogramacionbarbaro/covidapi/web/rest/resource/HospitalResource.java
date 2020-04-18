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
import org.springframework.web.bind.annotation.RestController;

import com.clubprogramacionbarbaro.covidapi.model.Hospital;
import com.clubprogramacionbarbaro.covidapi.service.HospitalService;
import com.clubprogramacionbarbaro.covidapi.web.rest.util.HospitalConstants;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(HospitalConstants.GLOBAL_CONTEXT_PATH)
@AllArgsConstructor
public class HospitalResource {

	private HospitalService hospitalService;

	@GetMapping(HospitalConstants.FIND_ALL_HOSPITALS)
	public ResponseEntity<List<Hospital>> findAllHospitals() {
		List<Hospital> hospitals = hospitalService.findAllHospitals();

		return new ResponseEntity<>(hospitals, HttpStatus.OK);
	}

	@GetMapping(HospitalConstants.FIND_HOSPITAL_BY_ID + "/{Id}")
	public ResponseEntity<Hospital> findHospitalById(@PathParam("Id") Integer hospitalId) {
		Hospital hospital = hospitalService.findHospitalById(hospitalId);

		return new ResponseEntity<>(hospital, HttpStatus.FOUND);
	}

	@PostMapping(HospitalConstants.SAVE_HOSPITAL)
	public ResponseEntity<Hospital> saveHospital(@RequestBody Hospital hospitalRequest) {
		Hospital hospitalResponse = hospitalService.saveHospital(hospitalRequest);

		return new ResponseEntity<>(hospitalResponse, HttpStatus.CREATED);
	}
	
	@PutMapping(HospitalConstants.UPDATE_HOSPITAL + "/{Id}")
	public ResponseEntity<Hospital> updateHospital(@PathParam("Id") Integer hospitalId, @RequestBody Hospital hospitalRequest){
		Hospital hospitalResponse = hospitalService.updateHospital(hospitalId, hospitalRequest);

		return new ResponseEntity<>(hospitalResponse, HttpStatus.OK);
	}
	
	@DeleteMapping(HospitalConstants.DELETE_HOSPITAL_BY_ID + "/{Id}")
	public ResponseEntity<Hospital> deleteHospitalById(@PathParam("Id") Integer hospitalId) {
		hospitalService.deleteHospitalById(hospitalId);

		return new ResponseEntity<>(HttpStatus.OK);
	}
}
