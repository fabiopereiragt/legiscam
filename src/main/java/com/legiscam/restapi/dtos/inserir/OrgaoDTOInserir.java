package com.legiscam.restapi.dtos.inserir;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import br.com.caelum.stella.bean.validation.CNPJ;

public class OrgaoDTOInserir {
	
		private long id;
		
	 	@NotEmpty(message = "Nome é obrigatório.")
	 	@Size(max = 80, message = "Quantidade maxima de caracteres é 80")
	    private String nome;
	 	
	 	@NotEmpty(message = "Sigla é obrigatório.")
	 	@Size(max = 10)
	    private String sigla;

	    @CNPJ(message="CNPJ inválido")
	    private String cnpj;
	    
		@Size(max = 80, message = "Quantidade maxima de caracteres é 80")
	    private String email;
		
		@Size(max = 80, message = "Quantidade maxima de caracteres é 80")
	    private String homePage;
		
		@NotEmpty(message = "Telefone é obrigatório")
		@Size(max = 15, message = "Quantidade maxima de caracteres é 15")
		private String telefone;
		
		@Size(max = 80, message = "Quantidade maxima de caracteres é 80")
	    private String logradouro;
	    
	    private int numero;
		
	    @Size(max = 40, message = "Quantidade maxima de caracteres é 40")
	    private String bairro;

		@Size(max = 30, message = "Quantidade maxima de caracteres é 30")
	    private String cep;
		
	    private Byte[] icone;
	    
	    @Positive(message = "Id da cidade é obrigatório")
		private long cidadeId;
	    
	    @Positive(message = "Id do estado é obrigatório")
		private long estadoId;
	   	    

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


		public String getCnpj() {
			return cnpj;
		}


		public void setCnpj(String cnpj) {
			this.cnpj = cnpj;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public String getHomePage() {
			return homePage;
		}


		public void setHomePage(String homePage) {
			this.homePage = homePage;
		}


		public String getTelefone() {
			return telefone;
		}


		public void setTelefone(String telefone) {
			this.telefone = telefone;
		}


		public String getLogradouro() {
			return logradouro;
		}


		public void setLogradouro(String logradouro) {
			this.logradouro = logradouro;
		}


		public int getNumero() {
			return numero;
		}


		public void setNumero(int numero) {
			this.numero = numero;
		}


		public String getBairro() {
			return bairro;
		}


		public void setBairro(String bairro) {
			this.bairro = bairro;
		}



		public String getCep() {
			return cep;
		}


		public void setCep(String cep) {
			this.cep = cep;
		}


		public Byte[] getIcone() {
			return icone;
		}


		public void setIcone(Byte[] icone) {
			this.icone = icone;
		}

		public long getCidadeId() {
			return cidadeId;
		}

		public void setCidadeId(long cidadeId) {
			this.cidadeId = cidadeId;
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
