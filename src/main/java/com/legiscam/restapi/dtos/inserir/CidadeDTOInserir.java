package com.legiscam.restapi.dtos.inserir;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class CidadeDTOInserir {
	
		private long id;
	
		@NotEmpty(message = "Nome é obrigatório")
		@Size(max = 80)
	    private String nome;

		@Positive(message = "Id do estado é obrigatório")
	    private long estadoId;
	    

	    public CidadeDTOInserir() {
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

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}


}
