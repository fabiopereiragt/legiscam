package com.legiscam.restapi.dtos.retorno;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.legiscam.restapi.enums.NaturezaMandato;
import com.legiscam.restapi.models.Mandato;

@JsonInclude(value = Include.NON_ABSENT) //Ignora no Json quando os campos são nulos
public class MandatoDTO extends DTOBase{

	
		private long id;		

		private LocalDate dataInicial;
		
		private LocalDate dataFinal;

		private NaturezaMandato natureza;		
		
		private long legislaturaId;		
		
		private long parlamentarId;	

		public MandatoDTO() {
			
		}
		

		public MandatoDTO(Mandato mandato) {
			this.id = mandato.getId();
			this.dataInicial = mandato.getDataInicial();
			this.dataFinal = mandato.getDataFinal();
			this.natureza = mandato.getNatureza();
			this.legislaturaId = mandato.getLegislatura().getId();
			this.parlamentarId = mandato.getParlamentar().getId();
		}

		public static List<MandatoDTO> Converter(List<Mandato> mandatos){
			
			return mandatos.stream().map(MandatoDTO::new).collect(Collectors.toList());
		}
		
		public static Page<MandatoDTO> Converter(Page<Mandato> mandatos){
			
			return mandatos.map(MandatoDTO::new);
		}
		
		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}
		
		public LocalDate getDataInicial() {
			return dataInicial;
		}

		public void setDataInicial(LocalDate dataInicial) {
			this.dataInicial = dataInicial;
		}

		public LocalDate getDataFinal() {
			return dataFinal;
		}

		public void setDataFinal(LocalDate dataFinal) {
			this.dataFinal = dataFinal;
		}

		public NaturezaMandato getNatureza() {
			return natureza;
		}

		public void setNatureza(NaturezaMandato natureza) {
			this.natureza = natureza;
		}

		public long getLegislaturaId() {
			return legislaturaId;
		}

		public void setLegislaturaId(long legislaturaId) {
			this.legislaturaId = legislaturaId;
		}

		public long getParlamentarId() {
			return parlamentarId;
		}

		public void setParlamentarId(long parlamentarId) {
			this.parlamentarId = parlamentarId;
		}				
	
		public String getPeriodoLegislatura() {
			return dataInicial + " - " + dataFinal;
		}
	
}
