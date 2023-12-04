// package com.jovemprogramador.eventosapp.models;

// import java.util.Collection;
// import java.util.List;
// import java.util.UUID;

// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.userdetails.UserDetails;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.JoinTable;
// import jakarta.persistence.ManyToMany;

// @Entity
// public class Usuario implements UserDetails {

// 	@SuppressWarnings("unused")
// 	private static final long serialVersionUId = 1L;

// 	@Id
// 	@GeneratedValue(strategy = GenerationType.AUTO)
// 	private UUID userId;

// 	@Column(nullable = false, unique = true)
// 	private String login;

// 	private String nomeCompleto;

// 	private String senha;

// 	@ManyToMany
// 	@JoinTable(name = "usuarios_roles", joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "login"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "nomeRole"))
// 	private List<Role> roles;

// 	public UUID getUserId() {
// 		return userId;
// 	}

// 	public void setUserId(UUID userId) {
// 		this.userId = userId;
// 	}

// 	public String getLogin() {
// 		return login;
// 	}

// 	public void setLogin(String login) {
// 		this.login = login;
// 	}

// 	public String getNomeCompleto() {
// 		return nomeCompleto;
// 	}

// 	public void setNomeCompleto(String nomeCompleto) {
// 		this.nomeCompleto = nomeCompleto;
// 	}

// 	public String getSenha() {
// 		return senha;
// 	}

// 	public void setSenha(String senha) {
// 		this.senha = senha;
// 	}

// 	@Override
// 	public Collection<? extends GrantedAuthority> getAuthorities() {
// 		return this.roles;
// 	}

// 	@Override
// 	public String getPassword() {
// 		return this.senha;
// 	}

// 	@Override
// 	public String getUsername() {
// 		return this.login;
// 	}

// 	@Override
// 	public boolean isAccountNonExpired() {
// 		return true;
// 	}

// 	@Override
// 	public boolean isAccountNonLocked() {
// 		return true;
// 	}

// 	@Override
// 	public boolean isCredentialsNonExpired() {
// 		return true;
// 	}

// 	@Override
// 	public boolean isEnabled() {
// 		return true;
// 	}

// }
