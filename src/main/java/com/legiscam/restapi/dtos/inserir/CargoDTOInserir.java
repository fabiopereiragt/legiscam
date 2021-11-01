package com.legiscam.restapi.dtos.inserir;

import javax.validation.constraints.NotEmpty;

public class CargoDTOInserir {

	private long id;
	
	@NotEmpty(message = "Nome é obrigatório")
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
}
