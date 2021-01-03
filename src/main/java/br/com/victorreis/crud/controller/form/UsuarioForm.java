package br.com.victorreis.crud.controller.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import br.com.victorreis.crud.model.Usuario;

public class UsuarioForm {
	@NotBlank(message = "Informe o nome")
	
	private String nome;
	@Email(message = "Informe um e-mail válido")
	private String email;
	
	@NotBlank(message = "Informe a senha")
	private String senha;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Usuario converter() {
		return new Usuario(nome, email, senha);
	}

}
