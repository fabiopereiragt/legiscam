package com.legiscam.restapi.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@SequenceGenerator(name="SEQUENCE", sequenceName="partido_id_seq")
@Entity
public class Partido extends EntidadeBase implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="partido_id_seq")
	private long id;
    	
	@Column(length=80)
	private String nome;

	@Column(length=10)
	private String sigla;
	
	private LocalDate dataCriacao;
	
    private LocalDate dataExtincao;
    
    @JsonBackReference(value = "reference-partido-parlamentar")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "partido")
    private Collection<Parlamentar> parlamentares;
    

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

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public LocalDate getDataExtincao() {
		return dataExtincao;
	}

	public void setDataExtincao(LocalDate dataExtincao) {
		this.dataExtincao = dataExtincao;
	}

	public Collection<Parlamentar> getParlamentares() {
		return parlamentares;
	}

	public void setParlamentares(Collection<Parlamentar> parlamentares) {
		this.parlamentares = parlamentares;
	}
    
	public void setId(long id) {
		this.id = id;
	}
	
	public long getId() {
		return id;
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
