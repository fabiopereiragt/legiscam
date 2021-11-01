package com.legiscam.restapi.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import com.legiscam.restapi.dtos.inserir.ParlamentarDTOInserir;
import com.legiscam.restapi.dtos.retorno.ParlamentarDTO;
import com.legiscam.restapi.models.Cidade;
import com.legiscam.restapi.models.GrauInstrucao;
import com.legiscam.restapi.models.Estado;
import com.legiscam.restapi.models.Parlamentar;
import com.legiscam.restapi.models.Partido;
import com.legiscam.restapi.repositories.ParlamentarRepository;

@Service
public class ParlamentarService extends ServiceGenerico<Parlamentar>{
	
	@Autowired
	private CidadeService cidadeService;	
	@Autowired
	private EstadoService estadoService;	
	@Autowired
	private PartidoService partidoService;
	@Autowired
	private EscolaridadeService escolaridadeService;
	
	@Autowired
	private ParlamentarRepository parlamentarService;
	
	public ParlamentarService() {
		
	}

	@Override
	protected String NomeDaEntidade() {
		return "Parlamentar";
	}

	@Override
	protected PagingAndSortingRepository<Parlamentar, Long> RetornaRepositorio() {
		return parlamentarService;
	}

	public Parlamentar MontaModelo(ParlamentarDTOInserir dto) {
		
		Parlamentar parlamentar = modelMapper.map(dto, Parlamentar.class);
		
		Cidade cidade = cidadeService.buscarPorId(dto.getCidadeId());
		Estado estado = estadoService.buscarPorId(dto.getEstadoId());
		Partido partido = partidoService.buscarPorId(dto.getPartidoId());
		GrauInstrucao escolaridade = escolaridadeService.buscarPorId(dto.getGrauInstrucaoId());
		
		parlamentar.setCidade(cidade);
		parlamentar.setEstado(estado);
		parlamentar.setPartido(partido);
		parlamentar.setEscolaridade(escolaridade);
		
		return parlamentar;
	}
	
	public ParlamentarDTO MontaDTORetorno(Parlamentar modelo) {
		
		if(modelo == null)
			return null;
		
		ParlamentarDTO parlamentarDTO = new ParlamentarDTO(modelo);
		
		return parlamentarDTO;
	}
	
	public List<ParlamentarDTO> MontaListaDTORetorno(List<Parlamentar> parlamentares){
		
		/*List<ParlamentarDTO> listaDTO = parlamentares.stream()
				.map(entity -> modelMapper.map(entity, ParlamentarDTO.class))
				.collect(Collectors.toList());*/


		List<ParlamentarDTO> listaDTO = ParlamentarDTO.Converter(parlamentares);
		
		return listaDTO;
	}
	
	public Page<ParlamentarDTO> MontaListaDTORetorno(Page<Parlamentar> parlamentares){

		Page<ParlamentarDTO> pagesDTO = ParlamentarDTO.Converter(parlamentares);
		
		return pagesDTO;
	}
	
	
	
}
