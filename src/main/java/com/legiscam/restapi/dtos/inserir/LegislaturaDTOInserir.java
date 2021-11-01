package com.legiscam.restapi.dtos.inserir;

import java.time.LocalDate;
import javax.validation.constraints.NotNull;


public class LegislaturaDTOInserir {
	
	private long id;
	
	//@PositiveOrZero(message = "Número é obrigatório")
	private String numero;
	
	@NotNull(message = "Data inicial é obrigatório")
    private LocalDate dataInicial;
	
    private LocalDate dataFinal;
    
	private boolean ativo;

    
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	public boolean getAtivo() {
		return ativo;
	}

	public LocalDate getDataFinal() {
		return dataFinal;
	}
	
	public void setDataFinal(LocalDate dataFinal) {
		this.dataFinal = dataFinal;
	}

	public LocalDate getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(LocalDate dataInicial) {
		this.dataInicial = dataInicial;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
