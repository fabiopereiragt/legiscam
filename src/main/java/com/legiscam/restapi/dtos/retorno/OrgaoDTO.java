package com.legiscam.restapi.dtos.retorno;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.legiscam.restapi.models.Orgao;

@JsonInclude(value = Include.NON_ABSENT) //Ignora no Json quando os campos são nulos
public class OrgaoDTO extends DTOBase{
	
	private long id;

    private String nome;

    private String sigla;
    
    private String cnpj;

    private String email;
	
    private String homePage;
	
	private String telefone;
	
    private String logradouro;
    
    private int numero;
	
    private String bairro;

    private long estadoId;
	
    private long cidadeId;
	
    private String cep;
	
    private Byte[] icone;
    
    public OrgaoDTO() {
    	
    }
    
    public OrgaoDTO(Orgao orgao) {
    	this.id = orgao.getId();
    	this.nome = orgao.getNome();
    	this.sigla = orgao.getSigla();
    	this.cnpj = orgao.getCnpj();
    	this.email = orgao.getEmail();
    	this.homePage = orgao.getHomePage();
    	this.telefone = orgao.getTelefone();
    	this.logradouro = orgao.getLogradouro();
    	this.numero = orgao.getNumero();
    	this.bairro = orgao.getBairro();
    	this.estadoId = orgao.getEstado().getId();
    	this.cidadeId = orgao.getCidade().getId();
    	this.cep = orgao.getCep();
    	this.icone = orgao.getIcone();   	
    }
    
    public static List<OrgaoDTO> Converter(List<Orgao> orgaos){
		
		return orgaos.stream().map(OrgaoDTO::new).collect(Collectors.toList());
	}
	
	public static Page<OrgaoDTO> Converter(Page<Orgao> orgaos){
		
		return orgaos.map(OrgaoDTO::new);
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


	public long getEstadoId() {
		return estadoId;
	}


	public void setEstadoId(long estadoId) {
		this.estadoId = estadoId;
	}


	public long getCidadeId() {
		return cidadeId;
	}

	public void setCidadeId(long cidadeId) {
		this.cidadeId = cidadeId;
	}
	

}
