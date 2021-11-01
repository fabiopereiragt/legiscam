package com.legiscam.restapi.services;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import com.legiscam.restapi.dtos.inserir.LegislaturaDTOInserir;
import com.legiscam.restapi.dtos.retorno.LegislaturaDTO;
import com.legiscam.restapi.models.Legislatura;
import com.legiscam.restapi.repositories.LegislaturaRepository;

@Service
public class LegislaturaService extends ServiceGenerico<Legislatura>{
	
	@Autowired
	private LegislaturaRepository legislaturaRepository;
	
	public LegislaturaService() {

	}	
	

	public Legislatura VerificaDataFinalDaLegislatura(Legislatura legislatura) {
		
		LocalDate dataInicial = legislatura.getDataInicial();
		LocalDate dataFinal = CalculaDataFinalLegislatura(dataInicial);
		
		if (legislatura.getDataFinal() == null)
			legislatura.setDataFinal(dataFinal);
			
				
		return legislatura;
	}
	
	private Legislatura VerificaSeLegislaturaEstaAtiva(Legislatura legislatura) {
		
		boolean ativa = legislatura.getDataFinal().isAfter(LocalDate.now());
		
		legislatura.setAtivo(ativa);
			
		return legislatura;		
	}
	
	public Legislatura ValidaLegislatura(Legislatura legislatura) {
		legislatura = VerificaDataFinalDaLegislatura(legislatura);
		legislatura = VerificaSeLegislaturaEstaAtiva(legislatura);
		
		return legislatura;
	}

	private LocalDate CalculaDataFinalLegislatura(LocalDate dataInicial) {
		int ano = dataInicial.getYear() + 4;
		int mes = dataInicial.getMonthValue();
		int dia = dataInicial.getDayOfMonth();
		
		return LocalDate.of(ano,mes,dia);
	}


	@Override
	protected String NomeDaEntidade() {
		return "Legislatura";
	}


	@Override
	protected PagingAndSortingRepository<Legislatura, Long> RetornaRepositorio() {
		return legislaturaRepository;
	}


	public Legislatura MontaModelo(LegislaturaDTOInserir dto) {
		
		Legislatura legislatura = modelMapper.map(dto, Legislatura.class);
		
		ValidaLegislatura(legislatura);
		
		return legislatura;
	}
	
	public LegislaturaDTO MontaDTORetorno(Legislatura model) {
		
		if(model == null)
			return null;
		
		LegislaturaDTO legislatura = new LegislaturaDTO(model);
		
		return legislatura;
	}
	
	public List<LegislaturaDTO> MontaListaDTORetorno(List<Legislatura> legislaturas){
		
		/*List<LegislaturaDTO> listaDTO = legislaturas.stream()
				.map(entity -> modelMapper.map(entity, LegislaturaDTO.class))
				.collect(Collectors.toList());*/
		
		List<LegislaturaDTO> listaDTO = LegislaturaDTO.Converter(legislaturas);


		return listaDTO;
	}
	
	public Page<LegislaturaDTO> MontaListaDTORetorno(Page<Legislatura> legislaturas){
		
		Page<LegislaturaDTO> pagesDTO = LegislaturaDTO.Converter(legislaturas);

		return pagesDTO;
	}

}
