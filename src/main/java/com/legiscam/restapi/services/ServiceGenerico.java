package com.legiscam.restapi.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectDeletedException;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import com.legiscam.restapi.error.ResourceInternalServerError;
import com.legiscam.restapi.error.ResourceNotFoundException;
import com.legiscam.restapi.models.EntidadeBase;

@Service
public abstract class ServiceGenerico<T> implements IServiceBase<T> {
    
	
	protected CrudRepository<T, Long> repository;
	
	protected ModelMapper modelMapper;
	
    protected abstract String NomeDaEntidade();
    protected abstract PagingAndSortingRepository<T, Long> RetornaRepositorio();
    
	
	public ServiceGenerico(CrudRepository<T, Long> repository) {
		this.repository = repository;
		this.modelMapper = new ModelMapper();
	}
	
	public ServiceGenerico() {
		this.modelMapper = new ModelMapper();
	}
	
	
	@Override
	public T salva(T model) {
		try {
			return (T) ((CrudRepository<T, Long>)RetornaRepositorio()).save(model);
			
		} catch (Exception e) {
			throw new ResourceInternalServerError("Erro ao salvar "+ NomeDaEntidade() + e);
		}
	}

	@Override
	public T atualiza(T model) {
		try {
			existeNoBanco(((EntidadeBase) model).getId());
			return (T) ((CrudRepository<T, Long>)RetornaRepositorio()).save(model);
		} catch (Exception e) {
			throw new ResourceInternalServerError("Erro ao atualizar " + NomeDaEntidade() + e);
		}
	}

	
	@Override
	public T buscarPorId(Long id) {
		existeNoBanco(id);
		return((CrudRepository<T, Long>)RetornaRepositorio()).findById(id).get();					
	}
	
	@Override
	public List<T> buscaTodos() {
		return (List<T>) ((CrudRepository<T, Long>)RetornaRepositorio()).findAll();					
	}
	
	
	public Page<T> buscaTodos(Pageable paginacao) {
		return (Page<T>) ((PagingAndSortingRepository<T, Long>)RetornaRepositorio()).findAll(paginacao);					
	}

	@Override
	public boolean deleta(Long id) {
		try {
			existeNoBanco(id);
			((CrudRepository<T, Long>)RetornaRepositorio()).deleteById(id);
			return true;
		} catch (ObjectDeletedException e) {
			throw new ResourceInternalServerError("Erro ao deletar "+ NomeDaEntidade() + e);
		}
	}

	@Override
	public void existeNoBanco(Long id) {
		Optional<T> entity = ((CrudRepository<T, Long>)RetornaRepositorio()).findById(id);
		if (!entity.isPresent()) {
			throw new ResourceNotFoundException(NomeDaEntidade() + " com o id = " + id + " não encontrado.");
		}
		
	}

	

}
