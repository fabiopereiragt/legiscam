package com.legiscam.restapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import com.legiscam.restapi.dtos.inserir.CargoDTOInserir;
import com.legiscam.restapi.dtos.retorno.CargoDTO;
import com.legiscam.restapi.models.Cargo;
import com.legiscam.restapi.repositories.CargoRepository;

@Service
public class CargoService extends ServiceGenerico<Cargo> {

	
	@Autowired
	private CargoRepository cargoRepository;
	
	@Override
	protected String NomeDaEntidade() {
		return "Cargo";
	}

	@Override
	protected PagingAndSortingRepository<Cargo, Long> RetornaRepositorio() {
		return cargoRepository;
	}


	public Cargo MontaModelo(CargoDTOInserir dto) {
				
		Cargo cargo = modelMapper.map(dto, Cargo.class);		
		
		return cargo;
	}
	
	public CargoDTO MontaDTORetorno(Cargo model) {
		
		CargoDTO cargoDTO = new CargoDTO(model);	
		
		return cargoDTO;
	}
	
	public List<CargoDTO> MontaListaDTORetorno(List<Cargo> cargos){
			
			/*List<CargoDTO> listaDTO = cargos.stream()
					.map(entity -> modelMapper.map(entity, CargoDTO.class))
					.collect(Collectors.toList());*/
		
		List<CargoDTO> listaDTO = CargoDTO.Converter(cargos);
		
		return listaDTO;
	}
	
	public Page<CargoDTO> MontaListaDTORetorno(Page<Cargo> cargos){

		Page<CargoDTO> pagesDTO = CargoDTO.Converter(cargos);
		
		return pagesDTO;
}
	
}
