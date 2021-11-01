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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.legiscam.restapi.dtos.inserir.MandatoDTOInserir;
import com.legiscam.restapi.dtos.retorno.MandatoDTO;
import com.legiscam.restapi.models.Mandato;
import com.legiscam.restapi.services.MandatoService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/mandato")
@Api(value="Api Mandato")
public class MandatoResource implements IResourcesBase<MandatoDTOInserir> {

	@Autowired
	private MandatoService mandatoService;
	

	@Override
	@PostMapping
	public ResponseEntity<?> salva(@Valid MandatoDTOInserir dto) {
		
		Mandato mandato = mandatoService.MontaModelo(dto);
		
		return ResponseEntity.ok(mandatoService.salva(mandato));
	}

	@Override
	@PutMapping
	public ResponseEntity<?> atualiza(@Valid MandatoDTOInserir dto) {	
		
		Mandato mandato = mandatoService.MontaModelo(dto);
		
		return ResponseEntity.ok(mandatoService.atualiza(mandato));
	}

	@Override
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> buscaPorId(@PathVariable("id") Long id) {
		
		MandatoDTO mandatoDTO = mandatoService.MontaDTORetorno(mandatoService.buscarPorId(id));
		
		return ResponseEntity.ok(mandatoDTO);
	}

	@Override
	@GetMapping
	public ResponseEntity<?> buscaTodos() {
		List<Mandato> mandatos = mandatoService.buscaTodos();
		
		return new ResponseEntity<Iterable<MandatoDTO>>(mandatoService.MontaListaDTORetorno(mandatos), HttpStatus.OK);
	}

	@Override
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> deleta(@PathVariable("id") Long id) {
		mandatoService.deleta(id);
		return new ResponseEntity<Mandato>(HttpStatus.OK);
	}
	
	@GetMapping(path = "/legislatura/{legislaturaId}")
	public ResponseEntity<?> buscaPorLegislaturaId(@PathVariable("legislaturaId") long legislaturaId){
		List<Mandato> mandatos = mandatoService.BuscaPorIdLegislatura(legislaturaId);
		return new ResponseEntity<Iterable<MandatoDTO>>(mandatoService.MontaListaDTORetorno(mandatos), HttpStatus.OK);
	}
	
	@GetMapping(path = "/parlamentar/{parlamentarId}")
	public ResponseEntity<?> buscaPorParlamentarId(@PathVariable("parlamentarId") long parlamentarId){
		List<Mandato> mandatos = mandatoService.BuscaPorIdParlamentar(parlamentarId);
		return new ResponseEntity<Iterable<MandatoDTO>>(mandatoService.MontaListaDTORetorno(mandatos), HttpStatus.OK);
	}
	
	
	@Override
	@GetMapping("/paginacao")
	public ResponseEntity<?> buscaTodosPaginacao(@RequestParam int pagina, @RequestParam int quantidade) {
		
		Pageable paginacao = PageRequest.of(pagina, quantidade);
		
		Page<Mandato> mandatos = mandatoService.buscaTodos(paginacao);
		
		return new ResponseEntity<Page<MandatoDTO>>(mandatoService.MontaListaDTORetorno(mandatos), HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}