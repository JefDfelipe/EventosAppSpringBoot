package com.jovemprogramador.eventosapp.models;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Role implements GrantedAuthority {

	private static final long serialVersionUID = 1L;

	@Id
	private String nomeRole;

	@ManyToMany
	private List<Usuario> usuarios;

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios_) {
		this.usuarios = usuarios_;
	}

	public String getNomeRole() {
		return nomeRole;
	}

	public void setNomeRole(String nomeRole_) {
		this.nomeRole = nomeRole_;
	}

	@Override
	public String getAuthority() {

		return this.nomeRole;
	}
}
