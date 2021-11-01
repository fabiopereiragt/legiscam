package com.legiscam.restapi.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Objects;

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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@SequenceGenerator(name="SEQUENCE", sequenceName="parlamentar_id_seq")
@Entity
public class Parlamentar extends EntidadeBase implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,generator="parlamentar_id_seq")
	private long id;
    
	private boolean ativo;
	
    @Column(length=1)
	private String sexo;
	
	@Column(length=80)
	private String nome;
	
	@Column(length=80)
	private String nomeSocial;
	
	@Column(length=80)
	private String nomeParlamentar;
	
	@Column(length=14)
	private String cpf;
	
	@Column(length=20)
	private String tituloEleitor;
	
	private LocalDate nascimento;
	
	@Column(length=80)
	private String logradouro;
	
	private int numero;
	
	@Column(length=80)
	private String bairro;
	
	@Column(length=80)
	private String email;
	
	@Column(length=15)
	private String telefone;
	
	@JsonBackReference(value = "reference-cidade-parlamentar")
	@JoinColumn(name = "cidadeId", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Cidade cidade;
	
	@JsonBackReference(value = "reference-estado-parlamentar")
	@JoinColumn(name = "estadoId", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Estado estado;
	
	@JsonBackReference(value = "reference-grauInstrucao-parlamentar")
	@JoinColumn(name = "grauInstrucaoId", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
	private GrauInstrucao grauInstrucao;
	
	@JsonBackReference(value = "reference-partido-parlamentar")
	@JoinColumn(name = "partidoId", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Partido partido;
	
	@JsonBackReference(value = "reference-mandato-parlamentar")
    @OneToMany(mappedBy = "parlamentar")
    private Collection<Mandato> mandatos;
	
	private Mandato mandato;
	
	public Mandato getMandato() {
		return mandato;
	}

	public void setMandato(Mandato mandato) {
		this.mandato = mandato;
	}

	@Column(length=20)
	private String cep;
	
	private byte[] foto;
	
	private String curriculo;

	
	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Collection<Mandato> getMandatos() {
		return mandatos;
	}

	public void setMandatos(Collection<Mandato> mandatos) {
		this.mandatos = mandatos;
	}
	
	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
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

	public GrauInstrucao getEscolaridade() {
		return grauInstrucao;
	}

	public void setEscolaridade(GrauInstrucao escolaridade) {
		this.grauInstrucao = escolaridade;
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

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
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

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
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
