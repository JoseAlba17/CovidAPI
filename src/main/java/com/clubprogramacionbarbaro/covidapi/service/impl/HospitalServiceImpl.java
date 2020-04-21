package com.clubprogramacionbarbaro.covidapi.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.clubprogramacionbarbaro.covidapi.dao.HospitalRepository;
import com.clubprogramacionbarbaro.covidapi.model.Hospital;
import com.clubprogramacionbarbaro.covidapi.service.HospitalService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class HospitalServiceImpl implements HospitalService {

	private HospitalRepository repository;

	@Override
	public List<Hospital> findAllHospitals() {
		
		return repository.findAll();
	}

	@Override
	public Hospital findHospitalById(Integer hospitalId) {

		return repository.findById(hospitalId).get();
	}

	@Override
	public Hospital saveHospital(Hospital hospital) {
		Date fechaActual = new Date();
		hospital.setFechaCreacion(fechaActual);
		return repository.save(hospital);
	}

	@Override
	public Hospital updateHospital(Integer hospitalId, Hospital hospital) {
		
		Date fechaActual = new Date();
		hospital.setFechaActualizacion(fechaActual);
		
		Hospital hospitalDB = findHospitalById(hospitalId);
		hospitalDB.setNombre(hospital.getNombre());
		hospitalDB.setDomicilio(hospital.getDomicilio());
		hospitalDB.setLatitud(hospital.getLatitud());
		hospitalDB.setLongitud(hospital.getLongitud());
		hospitalDB.setTipoInstitucion(hospital.getTipoInstitucion());
		hospitalDB.setFechaActualizacion(hospital.getFechaActualizacion());
		
		return repository.save(hospitalDB);
	}

	@Override
	public void deleteHospitalById(Integer hospitalId) {

		repository.deleteById(hospitalId);
	}
}