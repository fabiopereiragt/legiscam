package com.legiscam.restapi.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
/*import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;*/

//@EnableWebSecurity
//@Configuration
public class SecurityConfigurations /*extends WebSecurityConfigurerAdapter*/ {
	
	@Autowired
	AutenticacaoService autenticacaoService;
	
	//Configurações de autenticação
	/*@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(autenticacaoService).passwordEncoder(new BCryptPasswordEncoder());
	}*/
	
	//Configurações de autorização
	/*@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").permitAll();
		//.anyRequest().authenticated()
		//.and().formLogin();
	}*/
	
	//Configuração de recursos estaticos.
	/*@Override
	public void configure(WebSecurity web) throws Exception {
	}*/
	
	
	
	
}
