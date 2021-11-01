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

import com.legiscam.restapi.dtos.inserir.ParlamentarDTOInserir;
import com.legiscam.restapi.dtos.retorno.ParlamentarDTO;
import com.legiscam.restapi.models.Parlamentar;

import com.legiscam.restapi.services.ParlamentarService;


import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/parlamentar")
@Api(value="Api Parlamentar")
public class ParlamentarResource implements IResourcesBase<ParlamentarDTOInserir> {
	
	@Autowired
	private ParlamentarService parlamentarService;
	
	
	@Override
	@PostMapping
	public ResponseEntity<?> salva(@RequestBody @Valid ParlamentarDTOInserir dto) {
		Parlamentar parlamentar = new Parlamentar();
		
		parlamentar = parlamentarService.MontaModelo(dto);
					
		return ResponseEntity.ok(parlamentarService.salva(parlamentar));
	}	

	@Override
	@PutMapping
	public ResponseEntity<?> atualiza(@RequestBody @Valid ParlamentarDTOInserir dto) {
		
		Parlamentar parlamentar = new Parlamentar();
		
		parlamentar = parlamentarService.MontaModelo(dto);
		
		return ResponseEntity.ok(parlamentarService.atualiza(parlamentar));
	}

	@Override
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> buscaPorId(@PathVariable("id") Long id) {
		
		ParlamentarDTO parlamentarDTO = parlamentarService.MontaDTORetorno(parlamentarService.buscarPorId(id));
		
		return ResponseEntity.ok(parlamentarDTO);
	}

	@Override
	@GetMapping
	public ResponseEntity<?> buscaTodos() {
		List<Parlamentar> parlamentares = parlamentarService.buscaTodos();
		
		return new ResponseEntity<Iterable<ParlamentarDTO>>(parlamentarService.MontaListaDTORetorno(parlamentares), HttpStatus.OK);
	}

	@Override
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> deleta(@PathVariable("id") Long id) {
		parlamentarService.deleta(id);
		return new ResponseEntity<Parlamentar>(HttpStatus.OK);
	}
	
	@Override
	@GetMapping("/paginacao")
	public ResponseEntity<?> buscaTodosPaginacao(@RequestParam int pagina, @RequestParam int quantidade) {
		
		Pageable paginacao = PageRequest.of(pagina, quantidade);
		
		Page<Parlamentar> parlamentares = parlamentarService.buscaTodos(paginacao);
		
		return new ResponseEntity<Page<ParlamentarDTO>>(parlamentarService.MontaListaDTORetorno(parlamentares), HttpStatus.OK);
	}
	
	
	
}
