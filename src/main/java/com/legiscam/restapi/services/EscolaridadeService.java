package com.legiscam.restapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import com.legiscam.restapi.models.GrauInstrucao;
import com.legiscam.restapi.repositories.GrauInstrucaoRepository;

@Service
public class EscolaridadeService extends ServiceGenerico<GrauInstrucao> {

	@Autowired
	GrauInstrucaoRepository escolaridadeRepository;
	
	@Override
	protected String NomeDaEntidade() {
		return "Escolaridade";
	}

	@Override
	protected PagingAndSortingRepository<GrauInstrucao, Long> RetornaRepositorio() {
		return escolaridadeRepository;
	}

}
