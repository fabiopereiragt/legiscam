package com.legiscam.restapi.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

//import org.springframework.security.core.GrantedAuthority;

@SequenceGenerator(name="SEQUENCE", sequenceName="perfil_id_seq")
@Entity
public class Perfil /*implements GrantedAuthority*/{

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO, generator="perfil_id_seq")
	private long Id;
	
	private String nome;

	
	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	/*@Override
	public String getAuthority() {
		return nome;
	}*/
	
	

}
