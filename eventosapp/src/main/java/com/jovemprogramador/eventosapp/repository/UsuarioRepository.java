package com.jovemprogramador.eventosapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jovemprogramador.eventosapp.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
	Usuario findBylogin(String login);
}
