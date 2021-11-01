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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;




@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@SequenceGenerator(name="SEQUENCE", sequenceName="estado_id_seq")
@Entity
public class Estado extends EntidadeBase implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO,generator="estado_id_seq")
	private long id;
    
    
    @Basic(optional = false)
    @Column(columnDefinition = "varchar(80)")
    private String nome;

    @Basic(optional = false)
    @Column(columnDefinition = "varchar(2)")
    private String uf;

    @JoinColumn(name = "paisId", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Pais pais;

    @JsonBackReference(value = "reference-CIDADE-ESTADO")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estado")
    private Collection<Cidade> cidadeCollection;
    
    
    
    public Estado() {
    }

    public Estado(String nome, String uf, Pais pais) {
        this.nome = nome;
        this.uf = uf;
        this.pais = pais;
    }

    public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Collection<Cidade> getCidadeCollection() {
        return cidadeCollection;
    }

    public void setCidadeCollection(Collection<Cidade> cidadeCollection) {
        this.cidadeCollection = cidadeCollection;
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
