package com.legiscam.restapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import com.legiscam.restapi.dtos.inserir.PaisDTOInserir;
import com.legiscam.restapi.dtos.retorno.PaisDTO;
import com.legiscam.restapi.error.ResourceNotFoundException;
import com.legiscam.restapi.models.Pais;
import com.legiscam.restapi.repositories.PaisRepository;

@Service
public class PaisService extends ServiceGenerico<Pais> {
	
	@Autowired
	private PaisRepository paisRepository;
	
	public PaisService() {
		
	}	
	
	
	public Pais BuscarPorNome(String nome) {
		Pais pais = paisRepository.findByNome(nome);
		if (pais == null){
			throw new ResourceNotFoundException("Pais: " + nome + " não encontrado.");
		}
		return pais;
	}


	@Override
	protected String NomeDaEntidade() {
		return "Pais";
	}


	@Override
	protected PagingAndSortingRepository<Pais, Long> RetornaRepositorio() {
		return paisRepository;
	}

	public Pais MontaModelo(PaisDTOInserir dto) {
		
		Pais pais = modelMapper.map(dto, Pais.class);
		
		return pais;
	}
	
	public PaisDTO MontaDTORetorno(Pais modelo) {
		
		if(modelo == null)
			return null;
		
		PaisDTO paisDTO = new PaisDTO(modelo);
		
		return paisDTO;
	}
	
	public List<PaisDTO> MontaListaDTORetorno(List<Pais> paises){
		
		/*List<PaisDTO> listaDTO = paises.stream()
				.map(entity -> modelMapper.map(entity, PaisDTO.class))
				.collect(Collectors.toList());*/


		List<PaisDTO> listaDTO = PaisDTO.Converter(paises);
		
		return listaDTO;
	}
	
	public Page<PaisDTO> MontaListaDTORetorno(Page<Pais> paises){

		Page<PaisDTO> pagesDTO = PaisDTO.Converter(paises);
		
		return pagesDTO;
	}
}
