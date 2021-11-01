package com.legiscam.restapi.dtos.retorno;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import com.legiscam.restapi.models.Pais;

public class PaisDTO extends DTOBase{
	
	private long id;
	
    private String nome;

    private String sigla;
    
    public PaisDTO() {
    	
    }
    
    public PaisDTO(Pais pais) {
    	this.id = pais.getId();
    	this.nome = pais.getNome();
    	this.sigla = pais.getSigla();
    }

    public static List<PaisDTO> Converter(List<Pais> paises){
		
		return paises.stream().map(PaisDTO::new).collect(Collectors.toList());
	}
	
	public static Page<PaisDTO> Converter(Page<Pais> paises){
		
		return paises.map(PaisDTO::new);
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

}
