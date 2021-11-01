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

import com.legiscam.restapi.dtos.inserir.CargoDTOInserir;
import com.legiscam.restapi.dtos.retorno.CargoDTO;
import com.legiscam.restapi.models.Cargo;
import com.legiscam.restapi.services.CargoService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/cargo")
@Api(value="Api Cargo")
public class CargoResource implements IResourcesBase<CargoDTOInserir>{
	
	@Autowired
	private CargoService service;
	
	@Override
	@PostMapping
	public ResponseEntity<?> salva(@Valid @RequestBody CargoDTOInserir dto) {
		
		Cargo cargo = service.MontaModelo(dto);
		
		return ResponseEntity.ok(service.salva(cargo));
	}
	
	@Override
	@PutMapping
	public ResponseEntity<?> atualiza(@Valid @RequestBody CargoDTOInserir dto) {
		
		Cargo cargo = service.MontaModelo(dto);
		
		return ResponseEntity.ok(service.atualiza(cargo));
	}
	
	@Override
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> buscaPorId(@PathVariable("id") Long id) {		
		return ResponseEntity.ok(service.buscarPorId(id)); 
	}

	@Override
	@GetMapping
	public ResponseEntity<?> buscaTodos() {
		List<Cargo> cargos = service.buscaTodos();
		
		return new ResponseEntity<Iterable<CargoDTO>>(service.MontaListaDTORetorno(cargos), HttpStatus.OK);	
	}	

	@Override
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> deleta(@PathVariable("id") Long id) {
		service.deleta(id);
		return new ResponseEntity<Cargo>(HttpStatus.OK);
	}
	
	@Override
	@GetMapping("/paginacao")
	public ResponseEntity<?> buscaTodosPaginacao(@RequestParam int pagina, @RequestParam int quantidade) {
		
		Pageable paginacao = PageRequest.of(pagina, quantidade);
		
		Page<Cargo> cargos = service.buscaTodos(paginacao);
		
		return new ResponseEntity<Page<CargoDTO>>(service.MontaListaDTORetorno(cargos), HttpStatus.OK);
	}


}
