package com.clubprogramacionbarbaro.covidapi.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;

@Getter
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class HospitalNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 3263924381383735599L;

	private final Integer hospitalId;

	public HospitalNotFoundException(Integer hospitalId) {
		super(String.format("Hospital con el ID %d", hospitalId));
		this.hospitalId = hospitalId;
	}

}
