package com.legiscam.restapi.dtos.retorno;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.legiscam.restapi.models.Usuario;


public class UsuarioDTO extends DTOBase{
	
	private long id;
	
	private String matricula;

	private Boolean ativo;

	private String nome;

	private String email;

	private String cpf;

	private String login;

	private String senha;
	
    private long cargoId;
    
    public UsuarioDTO() {
    	
    }
    
	
	public UsuarioDTO(Usuario usuario) {
		this.id = usuario.getId();
		this.matricula = usuario.getMatricula();
		this.ativo = usuario.getAtivo();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		this.cpf = usuario.getCpf();
		this.login = usuario.getLogin();
		this.senha = usuario.getSenha();
		this.cargoId = usuario.getCargo().getId();
	}
	
	public static List<UsuarioDTO> Converter(List<Usuario> usuarios){
		
		return usuarios.stream().map(UsuarioDTO::new).collect(Collectors.toList());
	}
	
	public static Page<UsuarioDTO> Converter(Page<Usuario> usuarios){
		
		return usuarios.map(UsuarioDTO::new);
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
    
	public long getCargoId() {
		return cargoId;
	}

	public void setCargoId(long cargoId) {
		this.cargoId = cargoId;
	}

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

	
	@JsonIgnore
	public String getSenha() {
		return senha;
	}

	@JsonProperty
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
