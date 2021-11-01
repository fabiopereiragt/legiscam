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

import com.legiscam.restapi.dtos.inserir.CidadeDTOInserir;
import com.legiscam.restapi.dtos.retorno.CidadeDTO;
import com.legiscam.restapi.models.Cidade;
import com.legiscam.restapi.services.CidadeService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/cidade")
@Api(value="Api Cidade")
public class CidadeResource implements IResourcesBase<CidadeDTOInserir>{

	@Autowired
	private CidadeService cidadeService;
	

	
	@Override
	@PostMapping
	public ResponseEntity<?> salva(@RequestBody @Valid CidadeDTOInserir dto) {		
		Cidade cidade = cidadeService.MontaModelo(dto);
			
		return ResponseEntity.ok(cidadeService.salva(cidade));
	}

	@Override
	@PutMapping
	public ResponseEntity<?> atualiza(@RequestBody @Valid CidadeDTOInserir dto) {
		Cidade cidade = cidadeService.MontaModelo(dto);
		
		return ResponseEntity.ok(cidadeService.atualiza(cidade));
	}

	@Override
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> buscaPorId(@PathVariable("id") Long id) {
		
		CidadeDTO cidadeDTO = cidadeService.MontaDTORetorno(cidadeService.buscarPorId(id));
		
		return ResponseEntity.ok(cidadeDTO);
	}

	@Override
	@GetMapping
	public ResponseEntity<?> buscaTodos() {
		
		List<Cidade> cidades = cidadeService.buscaTodos();
		return new ResponseEntity<Iterable<CidadeDTO>>(cidadeService.MontaListaDTORetorno(cidades), HttpStatus.OK);
	}

	@Override
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> deleta(@PathVariable("id") Long id) {
		cidadeService.deleta(id);
		return new ResponseEntity<Cidade>(HttpStatus.OK);
	}
	
	@GetMapping(path = "/nome/{nome}")
	public ResponseEntity<?> buscaPorNome(@PathVariable("nome") String nome) {		
		return ResponseEntity.ok(cidadeService.BuscarPorNome(nome)); 
	}
	
	@GetMapping(path = "/estado/nome/{estado}")
	public ResponseEntity<?> buscaPorNomeDoEstado(@PathVariable("estado") String estado) {		
		return ResponseEntity.ok(cidadeService.BuscarPorNomeDoEstado(estado)); 
	}
	
	@GetMapping(path = "/estado/{idEstado}")
	public ResponseEntity<?> buscaPorIdDoEstado(@PathVariable("idEstado") long idEstado) {		
		return ResponseEntity.ok(cidadeService.BuscarPorIdDoEstado(idEstado)); 
	}
	
	@Override
	@GetMapping("/paginacao")
	public ResponseEntity<?> buscaTodosPaginacao(@RequestParam int pagina, @RequestParam int quantidade) {
		
		Pageable paginacao = PageRequest.of(pagina, quantidade);
		
		Page<Cidade> cidades = cidadeService.buscaTodos(paginacao);
		
		return new ResponseEntity<Page<CidadeDTO>>(cidadeService.MontaListaDTORetorno(cidades), HttpStatus.OK);
	}

}
