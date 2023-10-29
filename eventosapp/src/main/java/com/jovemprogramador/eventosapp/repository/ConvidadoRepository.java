package com.jovemprogramador.eventosapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jovemprogramador.eventosapp.models.Convidado;
import com.jovemprogramador.eventosapp.models.Evento;

public interface ConvidadoRepository extends JpaRepository<Convidado, String> {
	
	Iterable<Convidado> findByEvento(Evento evento); 
	Convidado findByRg(String rg);


}
