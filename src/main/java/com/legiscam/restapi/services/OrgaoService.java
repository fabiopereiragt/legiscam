package com.legiscam.restapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import com.legiscam.restapi.dtos.inserir.OrgaoDTOInserir;
import com.legiscam.restapi.dtos.retorno.OrgaoDTO;
import com.legiscam.restapi.models.Cidade;
import com.legiscam.restapi.models.Estado;
import com.legiscam.restapi.models.Orgao;
import com.legiscam.restapi.repositories.OrgaoRepository;

@Service
public class OrgaoService extends ServiceGenerico<Orgao> {

	@Autowired
	private OrgaoRepository orgaoRepository;
	
	@Autowired
	private EstadoService estadoService;
	
	@Autowired
	private CidadeService cidadeService;
	
	public OrgaoService() {
	}

	@Override
	protected String NomeDaEntidade() {
		return "Orgao";
	}

	@Override
	protected PagingAndSortingRepository<Orgao, Long> RetornaRepositorio() {
		return orgaoRepository;
	}

	public Orgao MontaModelo(OrgaoDTOInserir dto) {
		
		Orgao orgao = modelMapper.map(dto, Orgao.class);
		
		Cidade cidade = cidadeService.buscarPorId(dto.getCidadeId());
		Estado estado = estadoService.buscarPorId(dto.getEstadoId());
		
		orgao.setCidade(cidade);
		orgao.setEstado(estado);
		
		return orgao;
	}
	
	public OrgaoDTO MontaDTORetorno(Orgao modelo) {
		
		if(modelo == null)
			return null;
		
		OrgaoDTO orgao = new OrgaoDTO(modelo);
		
		return orgao;
	}
	
	public List<OrgaoDTO> MontaListaDTORetorno(List<Orgao> orgaos){
		
		/*List<OrgaoDTO> listaDTO = orgaos.stream()
				.map(entity -> modelMapper.map(entity, OrgaoDTO.class))
				.collect(Collectors.toList());*/

		List<OrgaoDTO> listaDTO = OrgaoDTO.Converter(orgaos);
		
		return listaDTO;
	}
	
	public Page<OrgaoDTO> MontaListaDTORetorno(Page<Orgao> orgaos){
		
		Page<OrgaoDTO> pagesDTO = OrgaoDTO.Converter(orgaos);
		
		return pagesDTO;
	}	
}
