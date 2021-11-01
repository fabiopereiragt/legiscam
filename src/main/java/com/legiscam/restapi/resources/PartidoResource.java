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

import com.legiscam.restapi.dtos.inserir.PartidoDTOInserir;
import com.legiscam.restapi.dtos.retorno.PartidoDTO;
import com.legiscam.restapi.models.Partido;
import com.legiscam.restapi.services.PartidoService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/partido")
@Api(value="Api Partido")
public class PartidoResource implements IResourcesBase<PartidoDTOInserir> {

	@Autowired
	private PartidoService partidoService;
	
	@Override
	@PostMapping
	public ResponseEntity<?> salva(@Valid @RequestBody PartidoDTOInserir dto) {
		
		Partido partido = partidoService.MontaModelo(dto);
		
		return ResponseEntity.ok(partidoService.salva(partido));
	}

	@Override
	@PutMapping
	public ResponseEntity<?> atualiza(@Valid @RequestBody PartidoDTOInserir dto) {
		
		Partido partido = partidoService.MontaModelo(dto);
		
		return ResponseEntity.ok(partidoService.atualiza(partido));
	}

	@Override
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> buscaPorId(@PathVariable("id") Long id) {		
		
		PartidoDTO partidoDTO = partidoService.MontaDTORetorno(partidoService.buscarPorId(id));
		
		return ResponseEntity.ok(partidoDTO); 
	}

	@Override
	@GetMapping
	public ResponseEntity<?> buscaTodos() {
		List<Partido> partidos = partidoService.buscaTodos();
		
		return new ResponseEntity<Iterable<PartidoDTO>>(partidoService.MontaListaDTORetorno(partidos), HttpStatus.OK);	
	}

	@Override
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> deleta(@PathVariable("id") Long id) {
		partidoService.deleta(id);
		return new ResponseEntity<Partido>(HttpStatus.OK);
	}
	
	@Override
	@GetMapping("/paginacao")
	public ResponseEntity<?> buscaTodosPaginacao(@RequestParam int pagina, @RequestParam int quantidade) {
		
		Pageable paginacao = PageRequest.of(pagina, quantidade);
		
		Page<Partido> partidos =  partidoService.buscaTodos(paginacao);
		
		return new ResponseEntity<Page<PartidoDTO>>(partidoService.MontaListaDTORetorno(partidos), HttpStatus.OK);
	}

}
