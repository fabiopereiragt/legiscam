	package com.legiscam.restapi.dtos.inserir;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import br.com.caelum.stella.bean.validation.CPF;

public class UsuarioDTOInserir {
	
	private long id;
	
	@NotEmpty(message = "Matricula é obrigatório.")
	@Size(max = 15)
	private String matricula;

	private Boolean ativo;

	@NotEmpty(message = "Nome é obrigatório.")
	@Size(max = 80)
	private String nome;

	@Email(message = "Email inválido.")
	private String email;

	@CPF(message = "Cpf inválido.")
	private String cpf;

	@Size(max = 30)
	@NotEmpty(message = "Login é obrigatório.")
	private String login;

	@Size(max = 160)
	@NotEmpty(message = "Senha é obrigatório.")
	private String senha;

	@Positive(message = "Id do cargo é obrigatório.")
    private long cargoId;
    
    

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public long getCargoId() {
		return cargoId;
	}

	public void setCargoId(long cargoId) {
		this.cargoId = cargoId;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}


}
