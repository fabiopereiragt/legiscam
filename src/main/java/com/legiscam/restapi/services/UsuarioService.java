package com.legiscam.restapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import com.legiscam.restapi.dtos.inserir.UsuarioDTOInserir;
import com.legiscam.restapi.dtos.retorno.UsuarioDTO;
import com.legiscam.restapi.models.Cargo;
import com.legiscam.restapi.models.Usuario;
import com.legiscam.restapi.repositories.UsuarioRepository;

@Service
public class UsuarioService extends ServiceGenerico<Usuario> {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private CargoService cargoService;
	
	public UsuarioService() {
	}

	@Override
	protected String NomeDaEntidade() {
		return "Usuário";
	}

	@Override
	protected PagingAndSortingRepository<Usuario, Long> RetornaRepositorio() {
		return usuarioRepository;
	}

	public Usuario MontaModelo(UsuarioDTOInserir dto) {
		
		Usuario usuario = modelMapper.map(dto, Usuario.class);
		
		Cargo cargo = cargoService.buscarPorId(dto.getCargoId());
		
		usuario.setCargo(cargo);
		
		return usuario;
	}
	
	public UsuarioDTO MontaDTORetorno(Usuario model) {
		
		if(model == null)
			return null;
		
		UsuarioDTO usuarioDTO = new UsuarioDTO(model);
		
		return usuarioDTO;
	}
	
	public Page<UsuarioDTO> MontaListaDTORetorno(Page<Usuario> usuarios){
		
		/*List<UsuarioDTO> listaDTO = usuarios.stream()
				.map(entity -> modelMapper.map(entity, UsuarioDTO.class))
				.collect(Collectors.toList());*/
		
		Page<UsuarioDTO> dtos = UsuarioDTO.Converter(usuarios);
		
		return dtos;
	}
	
	public List<UsuarioDTO> MontaListaDTORetorno(List<Usuario> usuarios){
		
		List<UsuarioDTO> dtos = UsuarioDTO.Converter(usuarios);
		
		return dtos;
	}
	
	public Optional<Usuario> BuscarPorLogin(String login){
		
		return usuarioRepository.findByLogin(login);
	}
	



}
