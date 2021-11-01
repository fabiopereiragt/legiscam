package com.legiscam.restapi.models;

import java.io.Serializable;
import java.time.LocalDate;
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
import com.legiscam.restapi.enums.NaturezaMandato;


@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@SequenceGenerator(name="SEQUENCE", sequenceName="mandato_id_seq")
@Entity
public class Mandato extends EntidadeBase implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,generator="mandato_id_seq")
	private long id;
    
	private LocalDate dataInicial;
	
	private LocalDate dataFinal;
	
    @Column(length=1)
	private NaturezaMandato natureza;
	
	@JsonBackReference(value = "reference-mandato-legislatura")
    @JoinColumn(name = "legislaturaId", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Legislatura legislatura;
    
	@JsonBackReference(value = "reference-mandato-parlamentar")
	@JoinColumn(name = "parlamentarId", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Parlamentar parlamentar;
	
 
    public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
    
	public Legislatura getLegislatura() {
		return legislatura;
	}

	public void setLegislatura(Legislatura legislatura) {
		this.legislatura = legislatura;
	}

	public LocalDate getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(LocalDate inicio) {
		this.dataInicial = inicio;
	}

	public LocalDate getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(LocalDate fim) {
		this.dataFinal = fim;
	}

	public NaturezaMandato getNatureza() {
		return natureza;
	}

	public void setParlamentar(Parlamentar parlamentar) {
		this.parlamentar = parlamentar;
	}
	
	public Parlamentar getParlamentar() {
		return parlamentar;
	}

	public void setNatureza(NaturezaMandato natureza) {
		this.natureza = natureza;
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



