package com.jovemprogramador.eventosapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jovemprogramador.eventosapp.models.Evento;

public interface EventoRepository extends JpaRepository<Evento, String> {
	
	Evento findByCodigo(long codigo);

}
