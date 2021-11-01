package com.legiscam.restapi.dtos.retorno;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import com.legiscam.restapi.models.Bairro;

public class BairroDTO extends DTOBase{
	
	private long id;	
	
    private String nome;

    private long cidadeId;
    
    public BairroDTO() {
		
	}
	
	public BairroDTO(Bairro bairro) {
		this.id = bairro.getId();
		this.nome = bairro.getNome();
		this.cidadeId = bairro.getCidade().getId();
	}
	
	public static List<BairroDTO> Converter(List<Bairro> bairros){
		
		return bairros.stream().map(BairroDTO::new).collect(Collectors.toList());
	}
	
	public static Page<BairroDTO> Converter(Page<Bairro> bairros){
		
		return bairros.map(BairroDTO::new);
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
    
	public long getCidadeId() {
		return cidadeId;
	}


	public void setCidadeNome(long cidadeId) {
		this.cidadeId = cidadeId;
	}

}
