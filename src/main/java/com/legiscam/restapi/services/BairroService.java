package com.legiscam.restapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import com.legiscam.restapi.dtos.inserir.BairroDTOInserir;
import com.legiscam.restapi.dtos.retorno.BairroDTO;
import com.legiscam.restapi.error.ResourceNotFoundException;
import com.legiscam.restapi.models.Bairro;
import com.legiscam.restapi.models.Cidade;
import com.legiscam.restapi.repositories.BairroRepository;

@Service
public class BairroService extends ServiceGenerico<Bairro>{
	
	
	@Autowired
	CidadeService cidadeService;
	
	@Autowired
	BairroRepository bairroRepository;
	
	public BairroService() {

	}

	public Bairro BuscarPorNome(String nome) {
		Bairro bairro = bairroRepository.findByNome(nome);
		if (bairro == null){
			throw new ResourceNotFoundException("Bairro: " + nome + " não encontrado.");
		}
		return bairro;
	}
	
	public List<Bairro> BuscarPorNomeDaCidade(String cidadeNome) {
		List<Bairro> bairros = bairroRepository.findByCidadeNome(cidadeNome);
		if (bairros.isEmpty()){
			throw new ResourceNotFoundException("Não foi encontrado nenhum bairro para a cidade: " + cidadeNome);
		}
		return bairros;
	}
	
	public List<Bairro> BuscarPorIdDaCidade(long cidadeId) {
		List<Bairro> bairros = bairroRepository.findByCidadeId(cidadeId);
		if (bairros.isEmpty()){
			throw new ResourceNotFoundException("Não foi encontrado nenhum bairro para a cidade com id: " + cidadeId);
		}
		return bairros;
	}
	
	@Override
	protected String NomeDaEntidade() {
		return "Bairro";
	}

	@Override
	protected PagingAndSortingRepository<Bairro, Long> RetornaRepositorio() {
		return bairroRepository; 
	}

	public Bairro MontaModelo(BairroDTOInserir dto) {
				
		Bairro bairro = modelMapper.map(dto, Bairro.class);
		
		Cidade cidade = cidadeService.buscarPorId(dto.getCidadeId());
		
		bairro.setCidade(cidade);
		
		
		return bairro;
	}
	
	public BairroDTO MontaDTORetorno(Bairro model) {
		BairroDTO bairroDTO = new BairroDTO(model);
		
		return bairroDTO;
	}
	
	public List<BairroDTO> MontaListaDTORetorno(List<Bairro> bairros){
		
		/*List<BairroDTO> listaDTO = bairros.stream()
				.map(entity -> modelMapper.map(entity, BairroDTO.class))
				.collect(Collectors.toList());*/
		
		List<BairroDTO> listaDTO = BairroDTO.Converter(bairros);

		return listaDTO;
	}
	
	public Page<BairroDTO> MontaListaDTORetorno(Page<Bairro> bairros){
		
		Page<BairroDTO> pagesDTO = BairroDTO.Converter(bairros);

		return pagesDTO;
	}




}
