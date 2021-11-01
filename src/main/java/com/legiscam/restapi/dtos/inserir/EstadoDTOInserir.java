package com.legiscam.restapi.dtos.inserir;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;


public class EstadoDTOInserir {
		
		private long id;
		
		@NotEmpty(message = "Nome é obrigatório")
		@Size(max = 80)
	    private String nome;
		
		@NotEmpty(message = "Uf é obrigatório")
		@Size(max = 2)
	    private String uf;
		
		@Positive(message = "Id do pais é obrigatório")
	    private long paisId;
	    
	    
	    public EstadoDTOInserir() {
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

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

	    

}
