package com.legiscam.restapi.dtos.inserir;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.legiscam.restapi.enums.NaturezaMandato;


public class MandatoDTOInserir {
	
	private long id;
	
	@Positive(message = "Id da legislatura é obrigatório")
	private long legislaturaId;
	
	@NotNull(message = "Data de inicio é obrigatório.")
	private LocalDate dataInicial;
	
	private LocalDate dataFinal;
	
	@NotNull(message = "Natureza é obrigatório.")
	private NaturezaMandato natureza;
	
	@Positive(message = "Id do parlamentar é obrigatório")
	private long parlamentarId;
	

	public long getParlamentarId() {
		return parlamentarId;
	}

	public void setParlamentarId(long parlamentarId) {
		this.parlamentarId = parlamentarId;
	}

	public LocalDate getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(LocalDate dataInicio) {
		this.dataInicial = dataInicio;
	}

	public LocalDate getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(LocalDate dataFim) {
		this.dataFinal = dataFim;
	}

	public NaturezaMandato getNatureza() {
		return natureza;
	}

	public void setNatureza(NaturezaMandato natureza) {
		this.natureza = natureza;
	}

	public long getLegislaturaId() {
		return legislaturaId;
	}

	public void setLegislaturaId(long legislaturaId) {
		this.legislaturaId = legislaturaId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


}
