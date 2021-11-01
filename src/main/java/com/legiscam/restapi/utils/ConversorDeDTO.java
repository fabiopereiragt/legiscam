package com.legiscam.restapi.utils;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.stream.Collectors;


import org.modelmapper.ModelMapper;

//Classe de exemplo de um conversor DTO genérico.
public class ConversorDeDTO<T, TDTO> {
	
	private final ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass(); 
	private Class<T> classeModelo = (Class<T>) (type).getActualTypeArguments()[0];
    private Class<TDTO> classeDTO = (Class<TDTO>) (type).getActualTypeArguments()[1];
    
    private ModelMapper modelMapper;
    
    public ConversorDeDTO() {
    	this.modelMapper = new ModelMapper();
    }
	
	public T DTOParaModel(TDTO dto) {
		
		T modelo = (T) this.modelMapper.map(dto, classeModelo);
		
		return modelo;
	}
	
	public TDTO ModelParaDTO(T model) throws Exception {
		
		try {
			
			TDTO dto = (TDTO) this.modelMapper.map(model, classeDTO);
			
			return dto;
			
		} catch (Exception e) {
			throw new Exception("Erro ao converter modelo para DTO" + e.getMessage());
		}
		
		
	}
	
	
	public List<T> ListaDTOParaListaModel(List<TDTO> listaDTO) throws Exception {
		try {
				
			//java.lang.reflect.Type typeLista = new TypeToken<List<TDTO>>() {}.getType();
			//List<TDTO> listaDTOs = modelMapper.map(listaModels, typeLista);
			
			List<T> listaModels = listaDTO.stream()
											.map(entity -> modelMapper.map(entity, classeModelo))
											.collect(Collectors.toList());
			
					
			return listaModels;
			
		} catch (Exception e) {
			throw new Exception("Erro ao converter lista de DTO para lista de modelo" + e.getMessage());
		}
	}
	

}
