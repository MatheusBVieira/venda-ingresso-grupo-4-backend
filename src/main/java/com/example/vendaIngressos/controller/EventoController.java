package com.example.vendaIngressos.controller;

import java.net.URI;

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
import org.springframework.web.util.UriComponentsBuilder;

import com.example.vendaIngressos.controller.dto.EventoDto;
import com.example.vendaIngressos.controller.form.AtualizacaoEventoForm;
import com.example.vendaIngressos.controller.form.EventoForm;
import com.example.vendaIngressos.model.Evento;
import com.example.vendaIngressos.service.EventoService;

@RestController
@RequestMapping("/evento")
public class EventoController {

	@Autowired
	private EventoService eventoService;

	@GetMapping
	public Page<EventoDto> lista(
			@PageableDefault(sort = "id", direction = Direction.DESC, page = 0, size = 10) Pageable paginacao) {

		return eventoService.lista(paginacao);

	}

	@PostMapping
	@Transactional
	public ResponseEntity<EventoDto> cadastrar(@RequestBody @Valid EventoForm form, UriComponentsBuilder uriBuilder) {
		Evento evento = eventoService.insere(form);

		URI uri = uriBuilder.path("/evento/{id}").buildAndExpand(evento.getId()).toUri();
		return ResponseEntity.created(uri).body(new EventoDto(evento));
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<EventoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoEventoForm form) {

		return eventoService.atualiza(id, form);

	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {

		return eventoService.deleta(id);

	}

}
