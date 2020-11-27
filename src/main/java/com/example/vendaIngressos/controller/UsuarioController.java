package com.example.vendaIngressos.controller;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.vendaIngressos.config.security.TokenService;
import com.example.vendaIngressos.controller.dto.UsuarioDto;
import com.example.vendaIngressos.controller.form.AtualizacaoUsuarioForm;
import com.example.vendaIngressos.controller.form.UsuarioForm;
import com.example.vendaIngressos.exception.IdNotFoundException;
import com.example.vendaIngressos.model.Usuario;
import com.example.vendaIngressos.service.UsuarioService;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private TokenService tokenService;

	@GetMapping
	public UsuarioDto retornaUsuarioLogado(HttpServletRequest request) {
		return new UsuarioDto(usuarioService.getOne(getIdUsuarioWithToken(request)).get());
	}

	@PostMapping
	@Transactional
	public ResponseEntity<UsuarioDto> cadastrar(@RequestBody @Valid UsuarioForm form, UriComponentsBuilder uriBuilder) {
		Usuario usuario = usuarioService.insere(form);
		return ResponseEntity.ok(new UsuarioDto(usuario));
	}

	@PutMapping
	@Transactional
	public ResponseEntity<UsuarioDto> atualizar(HttpServletRequest request,
			@RequestBody @Valid AtualizacaoUsuarioForm form) {
		Long id = getIdUsuarioWithToken(request);

		try {
			Usuario usuarioAtualizado = usuarioService.atualiza(id, form);
			return ResponseEntity.ok(new UsuarioDto(usuarioAtualizado));
		} catch (IdNotFoundException e) {
			e.printStackTrace();
			return ResponseEntity.notFound().build();
		}

	}

	@DeleteMapping
	@Transactional
	public ResponseEntity<?> remover(HttpServletRequest request) {
		Long id = getIdUsuarioWithToken(request);

		if (usuarioService.deleta(id)) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

	private Long getIdUsuarioWithToken(HttpServletRequest request) {
		return tokenService.getIdUsuario(tokenService.recuperarToken(request));
	}

}
