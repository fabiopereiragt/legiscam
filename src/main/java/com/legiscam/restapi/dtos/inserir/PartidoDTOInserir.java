package com.legiscam.restapi.dtos.inserir;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


public class PartidoDTOInserir {
	
	private long id;
	
	@NotEmpty(message = "Nome é obrigatório.")
	@Size(max = 80)
	private String nome;
	
	@NotEmpty(message = "Sigla é obrigatório.")
	@Size(max = 10)
	private String sigla;
	
	private LocalDate dataCriacao;
	
    private LocalDate dataExtincao;
    
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public LocalDate getDataExtincao() {
		return dataExtincao;
	}

	public void setDataExtincao(LocalDate dataExtincao) {
		this.dataExtincao = dataExtincao;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


}
