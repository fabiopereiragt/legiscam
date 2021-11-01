package com.legiscam.restapi.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum NaturezaMandato {

	@JsonProperty("T")
	TITULAR("T"),
	@JsonProperty("S")
	SUPLENTE("S");
	
	private final String valor;
	
	private NaturezaMandato(final String valor) {
		this.valor = valor;
	}
	
	@Override
	public String toString() {
		return valor;
	}
}
