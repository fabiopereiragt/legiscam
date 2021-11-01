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

import com.legiscam.restapi.dtos.inserir.BairroDTOInserir;
import com.legiscam.restapi.dtos.retorno.BairroDTO;
import com.legiscam.restapi.models.Bairro;
import com.legiscam.restapi.services.BairroService;

import io.swagger.annotations.Api;


@RestController
@RequestMapping(value = "/bairro")
@Api(value="Api Bairro")
public class BairroResource implements IResourcesBase<BairroDTOInserir> {
	
	
	@Autowired
	private BairroService bairroService;
	
	
	@Autowired
	public BairroResource() {	
	}
	
	@Override
	@PostMapping
	public ResponseEntity<?> salva(@RequestBody @Valid BairroDTOInserir dto) {		
		
		Bairro bairro = bairroService.MontaModelo(dto);
				
		return ResponseEntity.ok(bairroService.salva(bairro));
	}

	@Override
	@PutMapping
	public ResponseEntity<?> atualiza(@RequestBody @Valid BairroDTOInserir dto) {
		Bairro bairro = bairroService.MontaModelo(dto);
		
		return ResponseEntity.ok(bairroService.atualiza(bairro));
	}

	@Override
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> buscaPorId(@PathVariable("id") Long id) {
		return ResponseEntity.ok(bairroService.buscarPorId(id));
	}

	@Override
	@GetMapping
	public ResponseEntity<?> buscaTodos() {
		
		List<Bairro> bairros = bairroService.buscaTodos(); 	
		
		return new ResponseEntity<Iterable<BairroDTO>>(bairroService.MontaListaDTORetorno(bairros), HttpStatus.OK);
	}

	@Override
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> deleta(@PathVariable("id") Long id) {
		bairroService.deleta(id);
		return new ResponseEntity<Bairro>(HttpStatus.OK);
	}
	
	@GetMapping(path = "/nome/{nome}")
	public ResponseEntity<?> buscaPorNome(@PathVariable("nome") String nome) {		
		return ResponseEntity.ok(bairroService.BuscarPorNome(nome)); 
	}
	
	@GetMapping(path = "/cidade/nome/{cidade}")
	public ResponseEntity<?> BuscarPorNomeDaCidade(@PathVariable("cidade") String cidadeNome) {		
		return ResponseEntity.ok(bairroService.BuscarPorNomeDaCidade(cidadeNome)); 
	}
	
	@GetMapping(path = "/cidade/{idCidade}")
	public ResponseEntity<?> BuscarPorIdDaCidade(@PathVariable("idCidade") long idCidade) {		
		return ResponseEntity.ok(bairroService.BuscarPorIdDaCidade(idCidade)); 
	}

	@Override
	@GetMapping("/paginacao")
	public ResponseEntity<?> buscaTodosPaginacao(@RequestParam int pagina, @RequestParam int quantidade) {
		
		Pageable paginacao = PageRequest.of(pagina, quantidade);
		
		Page<Bairro> bairros = bairroService.buscaTodos(paginacao);
		
		return new ResponseEntity<Page<BairroDTO>>(bairroService.MontaListaDTORetorno(bairros), HttpStatus.OK);
	}
	

}
