package com.legiscam.restapi.models;

import java.io.Serializable;
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
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@SequenceGenerator(name="SEQUENCE", sequenceName="cargo_id_seq")
@Entity
public class Cargo extends EntidadeBase implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,generator="cargo_id_seq")
	private long id;
    
	@NotEmpty(message = "Informe um nome")
	@Column(length=80)
	private String nome;
	
	@JsonBackReference(value = "reference-cargo-usuario")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cargo")
    private Collection<Usuario> usuarios;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
    public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
