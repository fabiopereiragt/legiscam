package com.legiscam.restapi.dtos.retorno;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import com.legiscam.restapi.models.Estado;

public class EstadoDTO {
	
		private long id;
	
	    private String nome;

	    private String uf;
	    
	    private long paisId;
  
	    
	    public EstadoDTO() {
	    	
	    }
	    
	    public EstadoDTO(Estado estado) {
	    	this.id = estado.getId();
	    	this.nome = estado.getNome();
	    	this.uf = estado.getUf();
	    	this.paisId = estado.getPais().getId();
	    }
	        
	    public static List<EstadoDTO> Converter(List<Estado> estados){
			
			return estados.stream().map(EstadoDTO::new).collect(Collectors.toList());
		}
		
		public static Page<EstadoDTO> Converter(Page<Estado> estados){
			
			return estados.map(EstadoDTO::new);
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

	    public String getUf() {
	        return uf;
	    }

	    public void setUf(String uf) {
	        this.uf = uf;
	    }
	    
		public long getPaisId() {
			return paisId;
		}

		public void setPaisId(long paisId) {
			this.paisId = paisId;
		}


}
