package com.legiscam.restapi.config.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;*/
import org.springframework.stereotype.Service;

import com.legiscam.restapi.models.Usuario;
import com.legiscam.restapi.services.UsuarioService;

@Service
public class AutenticacaoService /*implements UserDetailsService*/ {
	
	@Autowired
	UsuarioService usuarioService;

	/*@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<Usuario> usuario = usuarioService.BuscarPorLogin(username);
		
		if (usuario.isPresent())
			return usuario.get();
		
		throw new UsernameNotFoundException("Usuário e/ou senha inválidos.");
	}*/
	
	

}
