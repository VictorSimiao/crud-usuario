package br.com.victorreis.crud.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.victorreis.crud.model.Usuario;

public class UsuarioDto {
	
	private Integer id;
	private String nome;
	private String email;
	
	public UsuarioDto(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}
	
	
	public static List<UsuarioDto> converter(List<Usuario> usuarios) {
		return usuarios.stream().map(UsuarioDto::new).collect(Collectors.toList());
	}
	
	
	
}
