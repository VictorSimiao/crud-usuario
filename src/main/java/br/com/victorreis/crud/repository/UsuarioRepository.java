package br.com.victorreis.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.victorreis.crud.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
