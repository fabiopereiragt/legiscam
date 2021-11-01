package com.legiscam.restapi.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.caelum.stella.bean.validation.CNPJ;


@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@SequenceGenerator(name="SEQUENCE", sequenceName="orgao_id_seq")
@Entity
public class Orgao extends EntidadeBase implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,generator="orgao_id_seq")
	private long id;
	
    @Column(length=80)
    private String nome;

    @Column(length=10)
    private String sigla;

	@Column(length=14)
    @CNPJ(message="CNPJ inválido")
    private String cnpj;
    
	@Column(length=80)
    private String email;
	
	@Column(length=80)
    private String homePage;
	
	@Column(length=15)
	private String telefone;
	
    @Column(length=80)
    private String logradouro;
    
    private int numero;
	
    @Column(length=40)
    private String bairro;

	@JsonBackReference(value = "reference-cidade-parlamentar")
	@JoinColumn(name = "cidadeId", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Cidade cidade;
	
	@JsonBackReference(value = "reference-estado-parlamentar")
	@JoinColumn(name = "estadoId", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Estado estado;

    @Column(length=30)
    private String cep;

	
    private Byte[] icone;
   
    
    public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
    
	public Cidade getCidade() {
		return cidade;
	}


	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}


	public Estado getEstado() {
		return estado;
	}


	public void setEstado(Estado estado) {
		this.estado = estado;
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
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return Objects.equals(id, this.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
	
    
    

}
