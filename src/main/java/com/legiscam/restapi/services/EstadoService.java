package com.legiscam.restapi.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import com.legiscam.restapi.dtos.inserir.EstadoDTOInserir;
import com.legiscam.restapi.dtos.retorno.EstadoDTO;
import com.legiscam.restapi.error.ResourceNotFoundException;
import com.legiscam.restapi.models.Estado;
import com.legiscam.restapi.models.Pais;
import com.legiscam.restapi.repositories.EstadoRepository;

@Service
public class EstadoService extends ServiceGenerico<Estado>{
		

	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private PaisService paisService;
	
	public EstadoService() {

	}	
	
	public Estado BuscarPorNome(String nome) {
		Estado estado = ((EstadoRepository)repository).findByNome(nome);
		if (estado == null){
			throw new ResourceNotFoundException("Estado: " + nome + " não encontrado.");
		}
		return estado;
	}
	
	public List<Estado> BuscarPorNomeDoPais(String pais) {
		List<Estado> estados = ((EstadoRepository)repository).findByNomePais(pais);
		if (estados.isEmpty()){
			throw new ResourceNotFoundException("Não foi encontrado nenhum estado para o país : " + pais);
		}
		return estados;
	}
	
	public List<Estado> BuscarPorIdDoPais(long pais) {
		List<Estado> estados = ((EstadoRepository)repository).findByIdPais(pais);
		if (estados.isEmpty()){
			throw new ResourceNotFoundException("Não foi encontrado nenhum estado para o país com id : " + pais);
		}
		return estados;
	}

	@Override
	protected String NomeDaEntidade() {
		return "Estado";
	}

	@Override
	protected PagingAndSortingRepository<Estado, Long> RetornaRepositorio() {
		return estadoRepository;
	}

	public Estado MontaModelo(EstadoDTOInserir dto) {
		Pais pais = paisService.buscarPorId(dto.getPaisId());
		
		Estado estado = modelMapper.map(dto, Estado.class);
		
		estado.setPais(pais);
		
		return estado;
	}
	
	public EstadoDTO MontaDTORetorno(Estado model) {
		
		if(model == null)
			return null;
		
		EstadoDTO estadoDTO = new EstadoDTO(model);
		
		return estadoDTO;
	}
	
	public List<EstadoDTO> MontaListaDTORetorno(List<Estado> estados){
		
		/*List<EstadoDTO> listaDTO = estados.stream()
				.map(entity -> modelMapper.map(entity, EstadoDTO.class))
				.collect(Collectors.toList());*/

		List<EstadoDTO> listaDTO = EstadoDTO.Converter(estados);
		
		return listaDTO;
	}
	
	public Page<EstadoDTO> MontaListaDTORetorno(Page<Estado> estados){
		
		Page<EstadoDTO> pagesDTO = EstadoDTO.Converter(estados);
		
		return pagesDTO;
	}
}
