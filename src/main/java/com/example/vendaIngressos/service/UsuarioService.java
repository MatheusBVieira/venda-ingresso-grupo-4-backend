package com.example.vendaIngressos.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.vendaIngressos.controller.dto.UsuarioDto;
import com.example.vendaIngressos.controller.form.AtualizacaoUsuarioForm;
import com.example.vendaIngressos.controller.form.UsuarioForm;
import com.example.vendaIngressos.model.Usuario;
import com.example.vendaIngressos.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Page<UsuarioDto> lista(Pageable paginacao) {
		Page<Usuario> usuarios = usuarioRepository.findAll(paginacao);
		return UsuarioDto.converter(usuarios);
	}

	public Usuario insere(UsuarioForm form) {
		Usuario usuario = form.converter();
		usuarioRepository.save(usuario);
		return usuario;
	}

	public ResponseEntity<UsuarioDto> atualiza(Long id, AtualizacaoUsuarioForm form) {
		Optional<Usuario> optional = usuarioRepository.findById(id);
		if (optional.isPresent()) {
			Usuario usuarioAtualizado = form.atualizar(id, usuarioRepository);
			return ResponseEntity.ok(new UsuarioDto(usuarioAtualizado));
		}

		return ResponseEntity.notFound().build();
	}

	public ResponseEntity<?> deleta(Long id) {
		Optional<Usuario> optional = usuarioRepository.findById(id);
		if (optional.isPresent()) {
			usuarioRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();
	}

	public UsuarioDto getUserById(Long id) {
		Usuario usuario = usuarioRepository.getOne(id);
		return UsuarioDto.converter(usuario);

	}

	public Usuario getOne(Long id) {
		return usuarioRepository.getOne(id);
	}

}
