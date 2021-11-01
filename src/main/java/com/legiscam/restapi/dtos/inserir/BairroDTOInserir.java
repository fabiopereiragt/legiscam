package com.legiscam.restapi.dtos.inserir;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;


public class BairroDTOInserir {
	
	private long id;
	
	@NotEmpty(message = "Nome é obrigatório.")
	@Size(max = 80)
    private String nome;
	
	@Positive(message = "Id da cidade é obrigatório.")
    private long cidadeId;
    
    
    public BairroDTOInserir() {
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getCidadeId() {
        return cidadeId;
    }

    public void setCidade(long cidadeId) {
        this.cidadeId = cidadeId;
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
