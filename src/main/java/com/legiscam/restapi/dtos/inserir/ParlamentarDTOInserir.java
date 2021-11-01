package com.legiscam.restapi.dtos.inserir;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;


import br.com.caelum.stella.bean.validation.CPF;

public class ParlamentarDTOInserir {
	
	private long id;
	
	private boolean ativo;
	
    @Size(max = 1)
	private String sexo;
	
    @NotEmpty(message = "Nome é obrigatório")
    @Size(max = 80)
	private String nome;
	
    @Size(max = 80)
	private String nomeSocial;
	
    @Size(max = 80)
	private String nomeParlamentar;
	
	@CPF(message = "CPF inválido.")
	private String cpf;
	
	@Size(max = 20)
	private String tituloEleitor;
	
	@NotNull(message="Data de nascimento é obrigatório.")
	private LocalDate nascimento;
	
	@Size(max = 80)
	private String logradouro;
	
	private int numero;
	
	@Size(max = 80)
	private String bairro;
	
	@Email
	@Size(max = 80)
	private String email;

	@Size(max = 15)
	@NotEmpty(message = "Telefone é obrigatório")
	private String telefone;
	
	@Size(max = 20)
	private String cep;
	
	private byte[] foto;
	
	private String curriculo;
	
	@Positive(message = "Id da cidade é obrigatório.")
	private long cidadeId;
	
	@Positive(message = "Id do estado é obrigatório.")
	private long estadoId;
	
	@Positive(message = "Id do grau de instrução é obrigatório.")
	private long grauInstrucaoId;
	
	@Positive(message = "Id do partido é obrigatório.")
	private long partidoId;
	
	
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

	public long getGrauInstrucaoId() {
		return grauInstrucaoId;
	}

	public void setGrauInstrucaoId(long grauInstrucaoId) {
		this.grauInstrucaoId = grauInstrucaoId;
	}

	public long getPartidoId() {
		return partidoId;
	}

	public void setPartidoId(long partidoId) {
		this.partidoId = partidoId;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeSocial() {
		return nomeSocial;
	}

	public void setNomeSocial(String nomeSocial) {
		this.nomeSocial = nomeSocial;
	}

	public String getNomeParlamentar() {
		return nomeParlamentar;
	}

	public void setNomeParlamentar(String nomeParlamentar) {
		this.nomeParlamentar = nomeParlamentar;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTituloEleitor() {
		return tituloEleitor;
	}

	public void setTituloEleitor(String tituloEleitor) {
		this.tituloEleitor = tituloEleitor;
	}

	public LocalDate getNascimento() {
		return nascimento;
	}

	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public String getCurriculo() {
		return curriculo;
	}

	public void setCurriculo(String curriculo) {
		this.curriculo = curriculo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
