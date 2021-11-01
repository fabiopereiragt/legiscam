package com.legiscam.restapi.dtos.retorno;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import com.legiscam.restapi.models.Cidade;


public class CidadeDTO extends DTOBase{
	

	private long id;
	
    private String nome;
    
    private long estadoId;
       
    public CidadeDTO() {
		
	}
    
    public CidadeDTO(Cidade cidade) {
    	this.id = cidade.getId();
		this.nome = cidade.getNome();
		this.estadoId = cidade.getEstado().getId();
	}
    
    public static List<CidadeDTO> Converter(List<Cidade> cidades){
		
		return cidades.stream().map(CidadeDTO::new).collect(Collectors.toList());
	}
	
	public static Page<CidadeDTO> Converter(Page<Cidade> cidades){
		
		return cidades.map(CidadeDTO::new);
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

	public long getEstadoId() {
		return estadoId;
	}

	public void setEstadoId(long estadoId) {
		this.estadoId = estadoId;
	}

}
