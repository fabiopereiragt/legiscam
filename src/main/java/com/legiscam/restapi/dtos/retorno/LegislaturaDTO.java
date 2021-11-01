package com.legiscam.restapi.dtos.retorno;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.legiscam.restapi.models.Legislatura;

@JsonInclude(value = Include.NON_ABSENT) //Ignora no Json quando os campos são nulos
public class LegislaturaDTO extends DTOBase{
	
	private long id;
	
    private int numero;
	
    private LocalDate dataInicial;
	
    private LocalDate dataFinal;
    
	private boolean ativo;
	
	public LegislaturaDTO() {
		
	}
	
	public LegislaturaDTO(Legislatura legislatura) {
		this.id = legislatura.getId();
		this.numero = legislatura.getNumero();
		this.dataInicial = legislatura.getDataInicial();
		this.dataFinal = legislatura.getDataFinal();
		this.ativo = legislatura.getAtivo();
	}
	
	public static List<LegislaturaDTO> Converter(List<Legislatura> legislaturas){
		
		return legislaturas.stream().map(LegislaturaDTO::new).collect(Collectors.toList());
	}
	
	public static Page<LegislaturaDTO> Converter(Page<Legislatura> legislaturas){
		
		return legislaturas.map(LegislaturaDTO::new);
	}

	public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
	
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

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}


}
