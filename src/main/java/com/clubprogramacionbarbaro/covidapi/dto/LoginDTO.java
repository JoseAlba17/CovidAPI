package com.clubprogramacionbarbaro.covidapi.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class LoginDTO {

	
	@NotBlank(message = "El campo de correo no puede estar vacio")
	@Email
	private String email;
	@NotBlank(message = "El campo de contraseña no puede estar vacio")
	private String contrasena;
}
