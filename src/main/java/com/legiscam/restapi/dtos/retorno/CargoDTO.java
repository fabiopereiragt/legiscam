package com.legiscam.restapi.dtos.retorno;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import com.legiscam.restapi.models.Cargo;

public class CargoDTO extends DTOBase{

	private long id;
	
	private String nome;
	
	public CargoDTO() {
		
	}

	public CargoDTO(Cargo cargo) {
		this.id = cargo.getId();
		this.nome = cargo.getNome();
	}
	
	public static List<CargoDTO> Converter(List<Cargo> cargos){
		
		return cargos.stream().map(CargoDTO::new).collect(Collectors.toList());
	}
	
	public static Page<CargoDTO> Converter(Page<Cargo> cargos){
		
		return cargos.map(CargoDTO::new);
	}
	
	public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
