package com.legiscam.restapi.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import com.legiscam.restapi.dtos.inserir.PartidoDTOInserir;
import com.legiscam.restapi.dtos.retorno.PartidoDTO;
import com.legiscam.restapi.models.Partido;
import com.legiscam.restapi.repositories.PartidoRepository;

@Service
public class PartidoService extends ServiceGenerico<Partido> {

	@Autowired
	PartidoRepository partidoRepository;
	
	public PartidoService() {
		
	}

	@Override
	protected String NomeDaEntidade() {
		return "Partido";
	}

	@Override
	protected PagingAndSortingRepository<Partido, Long> RetornaRepositorio() {
		return partidoRepository;
	}

	public Partido MontaModelo(PartidoDTOInserir dto) {
		
		Partido partido = modelMapper.map(dto, Partido.class);
		
		return partido;
	}	
	
	public PartidoDTO MontaDTORetorno(Partido model) {
		
		if(model == null)
			return null;
		
		PartidoDTO partidoDTO = new PartidoDTO(model);
		
		return partidoDTO;
	}	
	
	public List<PartidoDTO> MontaListaDTORetorno(List<Partido> partidos){	
		/*List<PartidoDTO> listaDTO = partidos.stream()
				.map(entity -> modelMapper.map(entity, PartidoDTO.class))
				.collect(Collectors.toList());*/
		
		
		List<PartidoDTO> listaDTO = PartidoDTO.Converter(partidos);

		return listaDTO;
	}
	
	public Page<PartidoDTO> MontaListaDTORetorno(Page<Partido> partidos){	
		
		Page<PartidoDTO> listaDTO = PartidoDTO.Converter(partidos);

		return listaDTO;
	}
}
