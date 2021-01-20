package br.com.victorreis.crud.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.victorreis.crud.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	Page<Usuario> findByNome(String nomeUsuario,Pageable paginacao);

}
