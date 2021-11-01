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

import com.legiscam.restapi.dtos.inserir.EstadoDTOInserir;
import com.legiscam.restapi.dtos.retorno.EstadoDTO;
import com.legiscam.restapi.models.Estado;
import com.legiscam.restapi.services.EstadoService;

import io.swagger.annotations.Api;


@RestController
@RequestMapping(value = "/estado")
@Api(value="Api Estado")
public class EstadoResource implements IResourcesBase<EstadoDTOInserir>{
	
	@Autowired
	private EstadoService estadoService;

	
	@Override
	@PostMapping
	public ResponseEntity<?> salva(@RequestBody @Valid EstadoDTOInserir dto) {
		Estado estado = estadoService.MontaModelo(dto);
		
		return ResponseEntity.ok(estadoService.salva(estado));
	}

	@Override
	@PutMapping
	public ResponseEntity<?> atualiza(@RequestBody @Valid EstadoDTOInserir dto) {
		Estado estado = estadoService.MontaModelo(dto);
		
		return ResponseEntity.ok(estadoService.atualiza(estado));
	}

	@Override
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> buscaPorId(@PathVariable("id") Long id) {
		Estado estado = estadoService.buscarPorId(id);
		return ResponseEntity.ok(estadoService.MontaDTORetorno(estado));
	}

	@Override
	@GetMapping
	public ResponseEntity<?> buscaTodos() {
		List<Estado> listaEstados = estadoService.buscaTodos();
		
		return new ResponseEntity<Iterable<EstadoDTO>>(estadoService.MontaListaDTORetorno(listaEstados), HttpStatus.OK);
	}

	@Override
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> deleta(@PathVariable("id") Long id) {
		estadoService.deleta(id);
		return new ResponseEntity<Estado>(HttpStatus.OK);
	}
	
	@GetMapping(path = "/nome/{nome}")
	public ResponseEntity<?> buscaPorNome(@PathVariable("nome") String nome) {		
		return ResponseEntity.ok(estadoService.BuscarPorNome(nome)); 
	}
	
	@GetMapping(path = "/pais/nome/{pais}")
	public ResponseEntity<?> buscaPorNomeDoPais(@PathVariable("pais") String pais) {		
		return ResponseEntity.ok(estadoService.BuscarPorNomeDoPais(pais)); 
	}
	
	@GetMapping(path = "/pais/{idPais}")
	public ResponseEntity<?> buscaPorNomeDoPais(@PathVariable("idPais") long idPais) {		
		return ResponseEntity.ok(estadoService.BuscarPorIdDoPais(idPais)); 
	}
	
	@Override
	@GetMapping("/paginacao")
	public ResponseEntity<?> buscaTodosPaginacao(@RequestParam int pagina, @RequestParam int quantidade) {
		
		Pageable paginacao = PageRequest.of(pagina, quantidade);
		
		Page<Estado> estados = estadoService.buscaTodos(paginacao);
		
		return new ResponseEntity<Page<EstadoDTO>>(estadoService.MontaListaDTORetorno(estados), HttpStatus.OK);
	}

}
