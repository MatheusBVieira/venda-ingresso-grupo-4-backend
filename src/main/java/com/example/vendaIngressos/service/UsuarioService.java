package com.example.vendaIngressos.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vendaIngressos.controller.form.AtualizacaoUsuarioForm;
import com.example.vendaIngressos.controller.form.UsuarioForm;
import com.example.vendaIngressos.exception.IdNotFoundException;
import com.example.vendaIngressos.model.Usuario;
import com.example.vendaIngressos.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario insere(UsuarioForm form) {
		Usuario usuario = form.converter();
		usuarioRepository.save(usuario);
		return usuario;
	}

	public Usuario atualiza(Long id, AtualizacaoUsuarioForm form) throws IdNotFoundException {
		Optional<Usuario> optional = this.getOne(id);
		if (optional.isPresent()) {
			Usuario usuarioAtualizado = form.atualizar(id, usuarioRepository);
			return usuarioAtualizado;
		}
		throw new IdNotFoundException("Problema na atualização do Usuario");
	}

	public boolean deleta(Long id) {
		Optional<Usuario> optional = usuarioRepository.findById(id);
		if (optional.isPresent()) {
			usuarioRepository.deleteById(id);
			return true;
		}

		return false;
	}

	public Optional<Usuario> getOne(Long id) {
		return usuarioRepository.findById(id);

	}

}
