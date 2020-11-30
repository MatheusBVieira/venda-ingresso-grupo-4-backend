package com.example.vendaIngressos.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vendaIngressos.controller.dto.EventoDto;
import com.example.vendaIngressos.controller.form.AtualizacaoEventoForm;
import com.example.vendaIngressos.controller.form.EventoForm;
import com.example.vendaIngressos.model.Evento;
import com.example.vendaIngressos.service.EventoService;
import com.example.vendaIngressos.service.UsuarioService;

@RestController
@RequestMapping("/evento")
public class EventoController {

	@Autowired
	private EventoService eventoService;

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping
	public Page<EventoDto> lista(
			@PageableDefault(sort = "id", direction = Direction.DESC, page = 0, size = 10) Pageable paginacao) {
		return eventoService.lista(paginacao);
	}

	@GetMapping("/{id}")
	public ResponseEntity<EventoDto> detalhar(@PathVariable Long id) {
		try {
			EventoDto evento = eventoService.detalhar(id);
			return ResponseEntity.ok(evento);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	@Transactional
	public ResponseEntity<EventoDto> cadastrar(@RequestBody @Valid EventoForm form, HttpServletRequest request)
			throws IOException {
		Evento evento = eventoService.insere(form, usuarioService.getIdUsuarioWithToken(request));
		return ResponseEntity.ok(new EventoDto(evento));
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<EventoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoEventoForm form) {
		try {
			Evento eventoAtualizado = eventoService.atualiza(id, form);
			return ResponseEntity.ok(new EventoDto(eventoAtualizado));
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return ResponseEntity.notFound().build();
		}

	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		if (eventoService.deleta(id)) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();

	}

}
