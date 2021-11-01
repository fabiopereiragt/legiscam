package com.legiscam.restapi.dtos.inserir;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class PaisDTOInserir {
	
		private long id;
	
		@NotEmpty(message = "Nome é obrigatório.")
	    @Size(max = 80)
	    private String nome;

	    @NotEmpty(message = "Sigla é obrigatório.")
	    @Size(max = 5)
	    private String sigla;

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

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}


}
