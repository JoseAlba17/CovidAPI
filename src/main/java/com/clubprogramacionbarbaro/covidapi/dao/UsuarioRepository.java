package com.clubprogramacionbarbaro.covidapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clubprogramacionbarbaro.covidapi.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	//SQL select * from usuario where email = ? and contrasena = ?
	//JPQL select u from usuario where email = ? and contrasena = ?
	Usuario findByEmailAndContrasena(String email, String contrasena);
	
	
}
