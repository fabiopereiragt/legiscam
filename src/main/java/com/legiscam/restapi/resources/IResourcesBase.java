package com.legiscam.restapi.resources;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.ApiOperation;

public interface IResourcesBase<T> {

	
    @PostMapping
    @ResponseBody
    @ApiOperation(value="Insere uma entidade")
    ResponseEntity<?> salva(@Valid @RequestBody  T model);

	
    @PutMapping
    @ResponseBody
    @ApiOperation(value="Atualiza uma entidade")
    ResponseEntity<?> atualiza(@Valid @RequestBody T model);

    @GetMapping(path = "/{id}")
    @ApiOperation(value="Busca entidade específica por ID")
    ResponseEntity<?> buscaPorId(@PathVariable Long id);

    @GetMapping
    @ResponseBody
    @ApiOperation(value="Busca todas as entidades")
    ResponseEntity<?> buscaTodos();
    
    @GetMapping
    @ResponseBody
    @ApiOperation(value="Busca todas as entidades com paginação")
    ResponseEntity<?> buscaTodosPaginacao(int pagina, int quantidade);

    @DeleteMapping(path = "/{id}")
    @ApiOperation(value="Exclui entidade específica por ID")
    ResponseEntity<?> deleta(@PathVariable Long id);
	
}
