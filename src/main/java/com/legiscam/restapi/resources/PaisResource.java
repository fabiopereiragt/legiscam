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

import com.legiscam.restapi.dtos.inserir.PaisDTOInserir;
import com.legiscam.restapi.dtos.retorno.PaisDTO;
import com.legiscam.restapi.models.Pais;
import com.legiscam.restapi.services.PaisService;

import io.swagger.annotations.Api;


@RestController
@RequestMapping(value = "/pais")
@Api(value="Api Pais")
public class PaisResource implements IResourcesBase<PaisDTOInserir> {
	
	@Autowired
	private PaisService service;

	
	@Override
	@PostMapping
	public ResponseEntity<?> salva(@Valid @RequestBody PaisDTOInserir dto) {
		
		Pais pais = service.MontaModelo(dto);
		
		return ResponseEntity.ok(service.salva(pais));
	}

	@Override
	@PutMapping
	public ResponseEntity<?> atualiza(@Valid @RequestBody PaisDTOInserir dto) {
		
		Pais pais = service.MontaModelo(dto);
		
		return ResponseEntity.ok(service.atualiza(pais));
	}

	@Override
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> buscaPorId(@PathVariable("id") Long id) {		
		
		PaisDTO paisDTO = service.MontaDTORetorno(service.buscarPorId(id));
		
		return ResponseEntity.ok(paisDTO); 
	}

	@Override
	@GetMapping
	public ResponseEntity<?> buscaTodos() {
		List<Pais> paises = service.buscaTodos();
		
		return new ResponseEntity<Iterable<PaisDTO>>(service.MontaListaDTORetorno(paises), HttpStatus.OK);	
	}

	@Override
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> deleta(@PathVariable("id") Long id) {
		service.deleta(id);
		return new ResponseEntity<Pais>(HttpStatus.OK);
	}

	@GetMapping(path = "/nome/{nome}")
	public ResponseEntity<?> buscaPorNome(@PathVariable("nome") String nome) {		
		return ResponseEntity.ok(service.BuscarPorNome(nome)); 
	}

	@Override
	@GetMapping("/paginacao")
	public ResponseEntity<?> buscaTodosPaginacao(@RequestParam int pagina, @RequestParam int quantidade) {
		
		Pageable paginacao = PageRequest.of(pagina, quantidade);
		
		Page<Pais> paises = service.buscaTodos(paginacao);
		
		return new ResponseEntity<Page<PaisDTO>>(service.MontaListaDTORetorno(paises), HttpStatus.OK);
	}
	
	

}
