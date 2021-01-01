package br.com.victorreis.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.victorreis.crud.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	List<Usuario> findByNome(String nomeUsuario);

}
