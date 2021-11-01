package com.legiscam.restapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import com.legiscam.restapi.dtos.inserir.GrauInstrucaoDTOInserir;
import com.legiscam.restapi.dtos.retorno.GrauInstrucaoDTO;
import com.legiscam.restapi.models.GrauInstrucao;
import com.legiscam.restapi.repositories.GrauInstrucaoRepository;

@Service
public class GrauInstrucaoService extends ServiceGenerico<GrauInstrucao>{

	public GrauInstrucaoService () {
		
	}
	
	@Autowired
	private GrauInstrucaoRepository grauInstrucaoRepository;
	
	
	public GrauInstrucao MontaModelo(GrauInstrucaoDTOInserir dto) {

		GrauInstrucao grauInstrucao = modelMapper.map(dto, GrauInstrucao.class);

		return grauInstrucao;
	}
	
	public GrauInstrucaoDTO MontaDTORetorno(GrauInstrucao model) {
		
		if(model == null)
			return null;
			
		GrauInstrucaoDTO grauDTO = new GrauInstrucaoDTO(model);
		
		return grauDTO;
	}
	
	public List<GrauInstrucaoDTO> MontaListaDTORetorno(List<GrauInstrucao> graisInstrucao){
		
		/*List<EstadoDTO> listaDTO = estados.stream()
				.map(entity -> modelMapper.map(entity, EstadoDTO.class))
				.collect(Collectors.toList());*/

		List<GrauInstrucaoDTO> listaDTO = GrauInstrucaoDTO.Converter(graisInstrucao);
		
		return listaDTO;
	}
	
	public Page<GrauInstrucaoDTO> MontaListaDTORetorno(Page<GrauInstrucao> graisInstrucao){
		
		Page<GrauInstrucaoDTO> pagesDTO = GrauInstrucaoDTO.Converter(graisInstrucao);
		
		return pagesDTO;
	}
	
	@Override
	protected String NomeDaEntidade() {
		return "Grau de Instrução";
	}

	@Override
	protected PagingAndSortingRepository<GrauInstrucao, Long> RetornaRepositorio() {
		return grauInstrucaoRepository;
	}

}
