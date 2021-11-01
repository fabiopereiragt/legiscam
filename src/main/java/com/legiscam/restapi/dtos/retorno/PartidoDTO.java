package com.legiscam.restapi.dtos.retorno;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.legiscam.restapi.models.Partido;

@JsonInclude(value = Include.NON_ABSENT) //Ignora no Json quando os campos são nulos
public class PartidoDTO extends DTOBase{


	private long id;
	
	private String nome;

	private String sigla;
	
	private LocalDate dataCriacao;
	
    private LocalDate dataExtincao;
    

    public PartidoDTO() {
    	
    }
    
    public PartidoDTO(Partido partido) {
    	this.id = partido.getId();
    	this.dataCriacao = partido.getDataCriacao();
    	this.dataExtincao = partido.getDataExtincao();
    	this.nome = partido.getNome();
    	this.sigla = partido.getSigla();
    }
    
    public static List<PartidoDTO> Converter(List<Partido> partidos){
		
		return partidos.stream().map(PartidoDTO::new).collect(Collectors.toList());
	}
	
	public static Page<PartidoDTO> Converter(Page<Partido> partidos){
		
		return partidos.map(PartidoDTO::new);
	}
    
	public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
	
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
    
}
