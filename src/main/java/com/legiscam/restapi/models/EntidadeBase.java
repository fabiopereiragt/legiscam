package com.legiscam.restapi.models;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonIgnore;

@MappedSuperclass
public abstract class EntidadeBase implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public abstract long getId();

	private LocalDate dataInsercao = LocalDate.now();

	@JsonIgnore
	public LocalDate getDataInsercao() {
		return dataInsercao;
	}

	public void setDataInsercao(LocalDate dataInsercao) {
		this.dataInsercao = dataInsercao;
	}

	
	
	
}
