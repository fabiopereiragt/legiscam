package com.legiscam.restapi.dtos.retorno;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.legiscam.restapi.models.Mandato;
import com.legiscam.restapi.models.Parlamentar;


@JsonInclude(value = Include.NON_ABSENT) //Ignora no Json quando os campos são nulos
public class ParlamentarDTO extends DTOBase{
	
		private long id;
		
		private String nome;
		
		private boolean ativo;
		
		private String sexo;
		
		private String nomeSocial;

		private String nomeParlamentar;
		
		private String cpf;

		private String tituloEleitor;

		private LocalDate nascimento;

		private String logradouro;
		
		private int numero;

		private String bairro;
		
		private String email;
		
		private String telefone;
		
		private String cep;
		
		private long cidadeId;

		private long estadoId;
		
		private long partidoId;

		private long grauInstrucaoId;
		
		@JsonProperty("mandatos")
		private List<MandatoDTO> mandatos; 
		
		/*@JsonProperty("mandatos")
		private Collection<Mandato> mandatos; */
		
		public ParlamentarDTO() {}
		
		public ParlamentarDTO(Parlamentar parlamentar) {
			this.id = parlamentar.getId();
			this.ativo = parlamentar.isAtivo();
			this.bairro = parlamentar.getBairro();
			this.cidadeId = parlamentar.getCidade().getId();
			this.cpf = parlamentar.getCpf();
			this.email = parlamentar.getEmail();
			this.grauInstrucaoId = parlamentar.getEscolaridade().getId();
			this.estadoId = parlamentar.getEstado().getId();
			this.logradouro = parlamentar.getLogradouro();
			this.nascimento = parlamentar.getNascimento();
			this.nome = parlamentar.getNome();
			this.nomeParlamentar = parlamentar.getNomeParlamentar();
			this.nomeSocial = parlamentar.getNomeSocial();
			this.numero = parlamentar.getNumero();
			this.cep = parlamentar.getCep();
			this.sexo = parlamentar.getSexo();
			this.telefone = parlamentar.getTelefone();
			this.tituloEleitor = parlamentar.getTituloEleitor();
			this.partidoId = parlamentar.getPartido().getId();
		    this.mandatos = MontaListaMandatos(parlamentar.getMandatos());	
			//this.mandatos = parlamentar.getMandatos();
		}

		public String getCep() {
			return cep;
		}

		public void setCep(String cep) {
			this.cep = cep;
		}
		
		private List<MandatoDTO> MontaListaMandatos(Collection<Mandato> mandatos) {
			
			ArrayList<Mandato> listaMandatos = new ArrayList<Mandato>(mandatos);
			
			return MandatoDTO.Converter(listaMandatos);
		} 


		/*  private Mandato[] MontaListaMandatos(Collection<Mandato> mandatos) {
			
			long[] idsMandatos = new long[mandatos.size()];
			
			int i = 0;
			
			for (Mandato mandato : mandatos) {
				idsMandatos[i] = mandato.getId();
				i++;
			}
			
			return idsMandatos;	
		} */

		public static List<ParlamentarDTO> Converter(List<Parlamentar> parlamentares){
			
			return parlamentares.stream().map(ParlamentarDTO::new).collect(Collectors.toList());
		}
		
		public static Page<ParlamentarDTO> Converter(Page<Parlamentar> parlamentares){
			
			return parlamentares.map(ParlamentarDTO::new);
		}
		
			
		public long getId() {
	        return id;
	    }

	    public void setId(long id) {
	        this.id = id;
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
		
		public long getPartidoId() {
			return partidoId;
		}

		public void setPartidoId(long partidoId) {
			this.partidoId = partidoId;
		}		
			
		public long getCidadeId() {
			return cidadeId;
		}
		public void setCidadeId(long cidadeId) {
			this.cidadeId = cidadeId;
		}
		public long getEstadoId() {
			return estadoId;
		}
		public void setEstadoId(long estadoId) {
			this.estadoId = estadoId;
		}
		public long getGrauInstrucaoId() {
			return grauInstrucaoId;
		}
		public void setGrauInstrucaoId(long escolaridadeId) {
			this.grauInstrucaoId = escolaridadeId;		
		}
		
}
