package br.com.victorreis.crud.controller;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.victorreis.crud.controller.dto.UsuarioDto;
import br.com.victorreis.crud.controller.form.UsuarioAtualizaForm;
import br.com.victorreis.crud.controller.form.UsuarioForm;
import br.com.victorreis.crud.model.Usuario;
import br.com.victorreis.crud.repository.UsuarioRepository;

@RequestMapping("/usuarios")
@RestController
public class UsuarioController {
	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping
	public ResponseEntity<Page<UsuarioDto>> lista(String nomeUsuario, @PageableDefault(sort="nome",direction = Direction.ASC,size = 10) Pageable paginacao) {
		if (nomeUsuario == null) {
			Page<Usuario> usuarios = usuarioRepository.findAll(paginacao);
			return ResponseEntity.ok(UsuarioDto.converter(usuarios));
		} else {
			Page<Usuario> usuarios = usuarioRepository.findByNome(nomeUsuario,paginacao);
			return ResponseEntity.ok(UsuarioDto.converter(usuarios));
		}
	}

	@PostMapping
	@Transactional
	public ResponseEntity<UsuarioDto> cadastrar(@RequestBody @Valid UsuarioForm usuarioForm,
			UriComponentsBuilder uriBuilder) {
		Usuario usuario = usuarioForm.converter();
		usuarioRepository.save(usuario);
		URI uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
		return ResponseEntity.created(uri).body(new UsuarioDto(usuario));
	}

	@GetMapping("/{id}")
	public ResponseEntity<UsuarioDto> detalhar(@PathVariable Integer id) {
		Optional<Usuario> optional = usuarioRepository.findById(id);
		if (optional.isPresent()) {
			return ResponseEntity.ok(new UsuarioDto(optional.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<UsuarioDto> atualizar(@PathVariable Integer id, @RequestBody UsuarioAtualizaForm form  ){
		Optional<Usuario> optional = usuarioRepository.findById(id);
		if(optional.isPresent()) {
			Usuario usuario = form.atualizar(id, usuarioRepository);
			return ResponseEntity.ok(new UsuarioDto(usuario));
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?>deletar(@PathVariable Integer id){
		Optional<Usuario> optional = usuarioRepository.findById(id);
		if(optional.isPresent()) {
			usuarioRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}

}
