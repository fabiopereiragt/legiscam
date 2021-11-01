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

import com.legiscam.restapi.dtos.inserir.OrgaoDTOInserir;
import com.legiscam.restapi.dtos.retorno.OrgaoDTO;
import com.legiscam.restapi.models.Estado;
import com.legiscam.restapi.models.Orgao;
import com.legiscam.restapi.services.OrgaoService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/orgao")
@Api(value="Api Orgao")
public class OrgaoResource implements IResourcesBase<OrgaoDTOInserir>{
	
	@Autowired
	private OrgaoService orgaoService;
	
	@Override
	@PostMapping
	public ResponseEntity<?> salva(@Valid OrgaoDTOInserir dto) {
		Orgao orgao = orgaoService.MontaModelo(dto);
		
		return ResponseEntity.ok(orgaoService.salva(orgao));
	}

	@Override
	@PutMapping
	public ResponseEntity<?> atualiza(@Valid OrgaoDTOInserir dto) {
		Orgao orgao = orgaoService.MontaModelo(dto);
		
		return ResponseEntity.ok(orgaoService.atualiza(orgao));
	}

	@Override
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> buscaPorId(Long id) {
		
		OrgaoDTO orgaoDTO = orgaoService.MontaDTORetorno(orgaoService.buscarPorId(id));
		
		return ResponseEntity.ok(orgaoDTO);
	}

	@Override
	@GetMapping
	public ResponseEntity<?> buscaTodos() {
		List<Orgao> orgaos = orgaoService.buscaTodos();
		
		return new ResponseEntity<Iterable<OrgaoDTO>>(orgaoService.MontaListaDTORetorno(orgaos), HttpStatus.OK);
	}

	@Override
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> deleta(Long id) {
		orgaoService.deleta(id);
		return new ResponseEntity<Estado>(HttpStatus.OK);
	}
	
	@Override
	@GetMapping("/paginacao")
	public ResponseEntity<?> buscaTodosPaginacao(@RequestParam int pagina, @RequestParam int quantidade) {
		
		Pageable paginacao = PageRequest.of(pagina, quantidade);
		
		Page<Orgao> orgaos = orgaoService.buscaTodos(paginacao);
		
		return new ResponseEntity<Page<OrgaoDTO>>(orgaoService.MontaListaDTORetorno(orgaos), HttpStatus.OK);
	}
	

}
