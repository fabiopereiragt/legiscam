package com.legiscam.restapi.services;

import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import com.legiscam.restapi.dtos.inserir.CidadeDTOInserir;
import com.legiscam.restapi.dtos.retorno.CidadeDTO;
import com.legiscam.restapi.error.ResourceNotFoundException;
import com.legiscam.restapi.models.Cidade;
import com.legiscam.restapi.models.Estado;
import com.legiscam.restapi.repositories.CidadeRepository;

@Service
public class CidadeService extends ServiceGenerico<Cidade>{
	
	@Autowired
	private CidadeRepository cidadeRepository;
		
	@Autowired
	private EstadoService estadoService;
	
	public CidadeService() {

	}	
	
	public Cidade BuscarPorNome(String nome) {
		Cidade cidade = cidadeRepository.findByNome(nome);
		if (cidade == null){
			throw new ResourceNotFoundException("Cidade: " + nome + " não encontrada.");
		}
		return cidade;
	}
	
	public List<Cidade> BuscarPorNomeDoEstado(String estado) {
		List<Cidade> cidades = cidadeRepository.findByNomeEstado(estado);
		if (cidades.isEmpty()){
			throw new ResourceNotFoundException("Não foi encontrado nenhuma cidade para o estado : " + estado);
		}
		return cidades;
	}
	
	public List<Cidade> BuscarPorIdDoEstado(long idEstado) {
		List<Cidade> cidades = cidadeRepository.findByIdEstado(idEstado);
		if (cidades.isEmpty()){
			throw new ResourceNotFoundException("Não foi encontrado nenhuma cidade para o estado com id : " + idEstado);
		}
		return cidades;
	}

	@Override
	protected String NomeDaEntidade() {
		return "Cidade";
	}

	@Override
	protected PagingAndSortingRepository<Cidade, Long> RetornaRepositorio() {
		return cidadeRepository;
	}

		
	public Cidade MontaModelo(CidadeDTOInserir dto) {
		
		ModelMapper modelMapper = new ModelMapper();		
		Cidade cidade = modelMapper.map(dto, Cidade.class);
		
		Estado estado = estadoService.buscarPorId(dto.getEstadoId());
		
		cidade.setEstado(estado);
				

		return cidade;
	}
	
	public CidadeDTO MontaDTORetorno(Cidade model) {
		
		if(model == null)
			return null;
		
		CidadeDTO cidadeDTO = new CidadeDTO(model);

		return cidadeDTO;
	}
	
	public List<CidadeDTO> MontaListaDTORetorno(List<Cidade> cidades){
		
		/*List<CidadeDTO> listaDTO = cidades.stream()
				.map(entity -> modelMapper.map(entity, CidadeDTO.class))
				.collect(Collectors.toList());*/

		List<CidadeDTO> listaDTO = CidadeDTO.Converter(cidades);
		return listaDTO;
	}
	
	public Page<CidadeDTO> MontaListaDTORetorno(Page<Cidade> cidades){
		
		Page<CidadeDTO> pagesDTO = CidadeDTO.Converter(cidades);
		
		return pagesDTO;
	}

}
