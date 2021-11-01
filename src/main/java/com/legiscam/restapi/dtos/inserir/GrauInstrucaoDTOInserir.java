package com.legiscam.restapi.dtos.inserir;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class GrauInstrucaoDTOInserir {
	
	private long id;
	
	@Size(max = 80)
	@NotEmpty
	private String descricao;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
