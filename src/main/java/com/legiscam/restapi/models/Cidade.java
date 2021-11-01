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
@SequenceGenerator(name="SEQUENCE", sequenceName="cidade_id_seq")
@Entity
public class Cidade extends EntidadeBase implements Serializable {

    private static final long serialVersionUID = 1L;
   
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO,generator="cidade_id_seq")
	private long id;


    @Basic(optional = false)
    @Column(columnDefinition = "varchar(80)")
    private String nome;

    @JsonBackReference(value = "reference-endereco-bairro")
    @JoinColumn(name = "estadoId", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Estado estado;
    

    @JsonBackReference(value = "reference-bairro-cidade")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cidade")
    private Collection<Bairro> bairroCollection;
    
    

    public Cidade() {
    }

    public Cidade(String nome, Estado estado) {
        this.nome = nome;
        this.estado = estado;
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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
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