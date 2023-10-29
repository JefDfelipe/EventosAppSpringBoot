package com.jovemprogramador.eventosapp.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jovemprogramador.eventosapp.models.Usuario;
import com.jovemprogramador.eventosapp.repository.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ImplementsUserDetailsService implements UserDetailsService {

//	@Autowired
//	UsuarioRepository usuarioRepository;

	// método secundário, sem usar AUTOWIRED
	final UsuarioRepository usuarioRepository;

	public ImplementsUserDetailsService(UsuarioRepository usuarioRepository_) {
		this.usuarioRepository = usuarioRepository_;
	}

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

		Usuario usuario = usuarioRepository.findBylogin(login);

		if (usuario == null) {
			throw new UsernameNotFoundException("USUÁRIO NÃO ENCONTRADO!");
		}
		return new User(usuario.getUsername(), usuario.getPassword(), true, true, true, true, usuario.getAuthorities());
	}
}