package com.legiscam.restapi.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@SequenceGenerator(name="SEQUENCE", sequenceName="legislatura_id_seq")
@Entity
public class Legislatura extends EntidadeBase implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,generator="legislatura_id_seq")
	private long id;
    
    private int numero;
	
    private LocalDate dataInicial;
	
    private LocalDate dataFinal;
    
	private boolean ativo;
	
	@JsonBackReference(value = "reference-legislatura-mandato")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "legislatura")
    private Collection<Mandato> mandatos;
    

    public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
    
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	public boolean getAtivo() {
		return ativo;
	}

	public LocalDate getDataFinal() {
		return dataFinal;
	}
	
	public void setDataFinal(LocalDate dataFinal) {
		this.dataFinal = dataFinal;
	}

	public LocalDate getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(LocalDate dataInicial) {
		this.dataInicial = dataInicial;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}


	public Collection<Mandato> getMandatos() {
		return mandatos;
	}

	public void setMandatos(Collection<Mandato> mandatos) {
		this.mandatos = mandatos;
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
