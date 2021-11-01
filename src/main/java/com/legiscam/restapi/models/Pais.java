package com.legiscam.restapi.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;



@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@SequenceGenerator(name="SEQUENCE", sequenceName="pais_id_seq")
@Entity
public class Pais extends EntidadeBase implements Serializable  {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO,generator="pais_id_seq")
	private long id;

    @Basic(optional = false)
    @Column(columnDefinition = "varchar(80)")
    private String nome;

    @Basic(optional = false)
    @Column(columnDefinition = "varchar(5)")
    private String sigla;

    @JsonBackReference(value = "reference-ESTADO-PAIS")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pais")
    private Collection<Estado> estadoCollection;

    public Pais() {
    }

    public Pais(String nome, String sigla) {
        this.nome = nome;
        this.sigla = sigla;
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

    public Collection<Estado> getEstadoCollection() {
        return estadoCollection;
    }

    public void setEstadoCollection(Collection<Estado> estadoCollection) {
        this.estadoCollection = estadoCollection;
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
