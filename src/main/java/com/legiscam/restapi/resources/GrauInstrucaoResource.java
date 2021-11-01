package com.legiscam.restapi.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.legiscam.restapi.dtos.inserir.GrauInstrucaoDTOInserir;
import com.legiscam.restapi.dtos.retorno.GrauInstrucaoDTO;
import com.legiscam.restapi.models.GrauInstrucao;
import com.legiscam.restapi.services.GrauInstrucaoService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/grauInstrucao")
@Api(value="Api Grau de instrução")
public class GrauInstrucaoResource implements IResourcesBase<GrauInstrucaoDTOInserir> {

	@Autowired
	private GrauInstrucaoService grauInstrucaoService;
	
	
	@Autowired
	public GrauInstrucaoResource() {	
	}
	
	@Override
	@PostMapping
	public ResponseEntity<?> salva(@RequestBody @Valid GrauInstrucaoDTOInserir dto) {		
		
		GrauInstrucao grauInstrucao = grauInstrucaoService.MontaModelo(dto);
				
		return ResponseEntity.ok(grauInstrucaoService.salva(grauInstrucao));
	}

	@Override
	@PutMapping
	public ResponseEntity<?> atualiza(@RequestBody @Valid GrauInstrucaoDTOInserir dto) {
		GrauInstrucao grauInstrucao = grauInstrucaoService.MontaModelo(dto);
		
		return ResponseEntity.ok(grauInstrucaoService.atualiza(grauInstrucao));
	}

	@Override
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> buscaPorId(@PathVariable("id") Long id) {
		
		GrauInstrucaoDTO grauInstrucaoDTO = grauInstrucaoService.MontaDTORetorno(grauInstrucaoService.buscarPorId(id));
		
		return ResponseEntity.ok(grauInstrucaoDTO);
	}

	@Override
	@GetMapping
	public ResponseEntity<?> buscaTodos() {
		
		List<GrauInstrucao> graisInstrucao = grauInstrucaoService.buscaTodos(); 	
		
		return new ResponseEntity<Iterable<GrauInstrucaoDTO>>(grauInstrucaoService.MontaListaDTORetorno(graisInstrucao), HttpStatus.OK);
	}

	@Override
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> deleta(@PathVariable("id") Long id) {
		grauInstrucaoService.deleta(id);
		return new ResponseEntity<GrauInstrucao>(HttpStatus.OK);
	}
	
	@Override
	@GetMapping("/paginacao")
	public ResponseEntity<?> buscaTodosPaginacao(@RequestParam int pagina, @RequestParam int quantidade) {
		
		Pageable paginacao = PageRequest.of(pagina, quantidade);
		
		Page<GrauInstrucao> graisInstrucao = grauInstrucaoService.buscaTodos(paginacao);
		
		return new ResponseEntity<Page<GrauInstrucaoDTO>>(grauInstrucaoService.MontaListaDTORetorno(graisInstrucao), HttpStatus.OK);
	}
	

}
