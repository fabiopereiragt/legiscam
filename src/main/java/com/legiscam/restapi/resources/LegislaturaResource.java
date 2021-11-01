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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.legiscam.restapi.dtos.inserir.LegislaturaDTOInserir;
import com.legiscam.restapi.dtos.retorno.LegislaturaDTO;
import com.legiscam.restapi.models.Legislatura;

import com.legiscam.restapi.services.LegislaturaService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/legislatura")
@Api(value="Api Legislatura")
public class LegislaturaResource implements IResourcesBase<LegislaturaDTOInserir> {

	@Autowired
	private LegislaturaService legislaturaService;

	
	@Override
	@PostMapping
	public ResponseEntity<?> salva(@Valid LegislaturaDTOInserir dto) {
		Legislatura legislatura = legislaturaService.MontaModelo(dto);
			
		return ResponseEntity.ok(legislaturaService.salva(legislatura));
	}

	@Override
	@PutMapping
	public ResponseEntity<?> atualiza(@Valid LegislaturaDTOInserir dto) {
		Legislatura legislatura = legislaturaService.MontaModelo(dto);
		
		return ResponseEntity.ok(legislaturaService.atualiza(legislatura));
	}

	@Override
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> buscaPorId(Long id) {
		
		LegislaturaDTO legislaturaDTO = legislaturaService.MontaDTORetorno(legislaturaService.buscarPorId(id));
		
		return ResponseEntity.ok(legislaturaDTO);
	}

	@Override
	@GetMapping
	public ResponseEntity<?> buscaTodos() {
		List<Legislatura> legislaturas = legislaturaService.buscaTodos();
		
		return new ResponseEntity<Iterable<LegislaturaDTO>>(legislaturaService.MontaListaDTORetorno(legislaturas), HttpStatus.OK);
	}

	@Override
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> deleta(Long id) {
		legislaturaService.deleta(id);
		return new ResponseEntity<Legislatura>(HttpStatus.OK);
	}
	
	@Override
	@GetMapping("/paginacao")
	public ResponseEntity<?> buscaTodosPaginacao(@RequestParam int pagina, @RequestParam int quantidade) {
		
		Pageable paginacao = PageRequest.of(pagina, quantidade);
		
		Page<Legislatura> legislaturas = legislaturaService.buscaTodos(paginacao);
		
		return new ResponseEntity<Page<LegislaturaDTO>>(legislaturaService.MontaListaDTORetorno(legislaturas), HttpStatus.OK);
	}

}
