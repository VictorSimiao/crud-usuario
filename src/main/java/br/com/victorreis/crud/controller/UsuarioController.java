package br.com.victorreis.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.victorreis.crud.controller.dto.UsuarioDto;
import br.com.victorreis.crud.model.Usuario;
import br.com.victorreis.crud.repository.UsuarioRepository;

@RequestMapping("/usuarios")
@RestController
public class UsuarioController {
	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping
	public List<UsuarioDto> lista(String nomeUsuario) {
		if(nomeUsuario == null) {
		List<Usuario> usuarios = usuarioRepository.findAll();
		return UsuarioDto.converter(usuarios);
		}else {
			List<Usuario> usuarios = usuarioRepository.findByNome(nomeUsuario);
			return UsuarioDto.converter(usuarios);
		}
	}

}
