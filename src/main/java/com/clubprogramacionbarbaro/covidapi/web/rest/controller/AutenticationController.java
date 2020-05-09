package com.clubprogramacionbarbaro.covidapi.web.rest.controller;

import java.util.Calendar;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clubprogramacionbarbaro.covidapi.dao.UsuarioRepository;
import com.clubprogramacionbarbaro.covidapi.dto.LoginDTO;
import com.clubprogramacionbarbaro.covidapi.dto.MessageDTO;
import com.clubprogramacionbarbaro.covidapi.dto.TokenDTO;
import com.clubprogramacionbarbaro.covidapi.model.Usuario;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("autentication")
@AllArgsConstructor
public class AutenticationController {

	private UsuarioRepository repository;

	@PostMapping
	public ResponseEntity<?> authenticate(@RequestBody LoginDTO loginDTO) {
		Usuario usuario = repository.findByEmailAndContrasena(loginDTO.getEmail(), loginDTO.getContrasena());

		if (usuario != null) {

			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.HOUR, 1);

			String jwt = Jwts.builder()
					.setSubject(usuario.getEmail())
					.claim("role", "user")
					.setExpiration(calendar.getTime())
					.signWith(SignatureAlgorithm.HS256, "12345678")
					.compact();
			
			TokenDTO tokenDTO = new TokenDTO(jwt);
			return new ResponseEntity<>(tokenDTO, HttpStatus.OK);
		} else {
			MessageDTO messageDTO = new MessageDTO("error", "El usuario o la contraseña son incorrectos");
			return ResponseEntity
					.status(HttpStatus.UNAUTHORIZED)
					.body(messageDTO);
		}
	}
}
