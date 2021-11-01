package com.legiscam.restapi.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import com.legiscam.restapi.dtos.inserir.MandatoDTOInserir;
import com.legiscam.restapi.dtos.retorno.MandatoDTO;
import com.legiscam.restapi.error.ResourceNotFoundException;
import com.legiscam.restapi.models.Legislatura;
import com.legiscam.restapi.models.Mandato;
import com.legiscam.restapi.models.Parlamentar;
import com.legiscam.restapi.repositories.MandatoRepository;

@Service
public class MandatoService extends ServiceGenerico<Mandato> {

	@Autowired
	MandatoRepository mandatoRepository;
	
	@Autowired
	LegislaturaService legislaturaService;
	
	@Autowired
	ParlamentarService parlamentarService;
	
	
	public List<Mandato> BuscaPorIdLegislatura(long idLegislatura){
		
		List<Mandato> mandatos = mandatoRepository.findByIdLegislatura(idLegislatura);
		
		if(mandatos.isEmpty())	
		throw new ResourceNotFoundException("NÃ£o foi encontrado nenhum mandato para a legislatura com id : " + idLegislatura);
		
		return mandatos;
	}
	
	public List<Mandato> BuscaPorIdParlamentar(long idParlamentar){
		
		List<Mandato> mandatos = mandatoRepository.findByIdParlamentar(idParlamentar);
		
		if(mandatos.isEmpty())	
		throw new ResourceNotFoundException("Não foi encontrado nenhum mandato para o parlamentar com id : " + idParlamentar);
		
		return mandatos;
	}
	
	@Override
	protected String NomeDaEntidade() {
		return "Mandato";
	}

	@Override
	protected PagingAndSortingRepository<Mandato, Long> RetornaRepositorio() {
		return mandatoRepository;
	}


	public Mandato MontaModelo(MandatoDTOInserir dto) {
		
		Mandato mandato = modelMapper.map(dto, Mandato.class);		
		Legislatura legislatura = legislaturaService.buscarPorId(dto.getLegislaturaId());		
		Parlamentar parlamentar = parlamentarService.buscarPorId(dto.getParlamentarId());
		
		mandato.setLegislatura(legislatura);
		mandato.setParlamentar(parlamentar);		
		
		return mandato;
	}
	
	public MandatoDTO MontaDTORetorno(Mandato model) {
		
		if(model == null)
			return null;
		
		MandatoDTO mandatoDto = new MandatoDTO(model);

		return mandatoDto;
	}
	
	public List<MandatoDTO> MontaListaDTORetorno(List<Mandato> mandatos){
		
		/*List<MandatoDTO> listaDTO = mandatos.stream()
				.map(entity -> modelMapper.map(entity, MandatoDTO.class))
				.collect(Collectors.toList());*/

		List<MandatoDTO> listaDTO = MandatoDTO.Converter(mandatos)
;		
		return listaDTO;
	}
	
	public Page<MandatoDTO> MontaListaDTORetorno(Page<Mandato> mandatos){

		Page<MandatoDTO> pagesDTO = MandatoDTO.Converter(mandatos);		
		return pagesDTO;
	}
	

}
