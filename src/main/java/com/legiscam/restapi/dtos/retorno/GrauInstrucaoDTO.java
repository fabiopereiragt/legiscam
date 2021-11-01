package com.legiscam.restapi.dtos.retorno;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.data.domain.Page;

import com.legiscam.restapi.models.GrauInstrucao;

public class GrauInstrucaoDTO {
	
	public GrauInstrucaoDTO() {
		
	}
	
	public GrauInstrucaoDTO(GrauInstrucao grauInstrucao) {
		this.id = grauInstrucao.getId();
		this.descricao = grauInstrucao.getDescricao();
	}
	
	public static List<GrauInstrucaoDTO> Converter(List<GrauInstrucao> graisInstrucao){
		
		return graisInstrucao.stream().map(GrauInstrucaoDTO::new).collect(Collectors.toList());
	}
	
	public static Page<GrauInstrucaoDTO> Converter(Page<GrauInstrucao> graisInstrucao){
		
		return graisInstrucao.map(GrauInstrucaoDTO::new);
	}
	
	private long id;
	
	@Size(max = 80)
	@NotEmpty
	private String descricao;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


}
