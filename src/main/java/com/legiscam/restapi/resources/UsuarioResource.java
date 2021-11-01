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

import com.legiscam.restapi.dtos.inserir.UsuarioDTOInserir;
import com.legiscam.restapi.dtos.retorno.UsuarioDTO;
import com.legiscam.restapi.models.Usuario;
import com.legiscam.restapi.services.UsuarioService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/usuario")
@Api(value="Usuário resouce")
public class UsuarioResource implements IResourcesBase<UsuarioDTOInserir> {

	@Autowired
	private UsuarioService usuarioService;

	@Override
	@PostMapping
	public ResponseEntity<?> salva(@Valid UsuarioDTOInserir dto) {
		
		Usuario usuario = usuarioService.MontaModelo(dto);
		
		return ResponseEntity.ok(usuarioService.salva(usuario));
	}

	@Override
	@PutMapping
	public ResponseEntity<?> atualiza(UsuarioDTOInserir dto) {
		
		Usuario usuario = usuarioService.MontaModelo(dto);
		
		return ResponseEntity.ok(usuarioService.atualiza(usuario));
	}

	@Override
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> buscaPorId(@PathVariable("id") Long id) {	
		
		UsuarioDTO usuario = usuarioService.MontaDTORetorno(usuarioService.buscarPorId(id));
		
		return ResponseEntity.ok(usuario); 
	}

	@Override
	@GetMapping
	public ResponseEntity<?> buscaTodos() {
		List<Usuario> usuarios = usuarioService.buscaTodos();
		
		return new ResponseEntity<List<UsuarioDTO>>(usuarioService.MontaListaDTORetorno(usuarios), HttpStatus.OK);		
	}
	
	@Override
	@GetMapping("/paginacao")
	public ResponseEntity<?> buscaTodosPaginacao(@RequestParam int pagina, @RequestParam int quantidade) {
		
		Pageable paginacao = PageRequest.of(pagina, quantidade);
		
		Page<Usuario> usuarios = usuarioService.buscaTodos(paginacao);
		
		return new ResponseEntity<Page<UsuarioDTO>>(usuarioService.MontaListaDTORetorno(usuarios), HttpStatus.OK);
	}

	
	@Override
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> deleta(Long id) {
		usuarioService.deleta(id);
		return new ResponseEntity<Usuario>(HttpStatus.OK);
	}
	
}
