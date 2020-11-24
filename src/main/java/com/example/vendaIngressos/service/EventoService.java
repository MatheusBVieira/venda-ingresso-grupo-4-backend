package com.example.vendaIngressos.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.vendaIngressos.controller.dto.EventoDto;
import com.example.vendaIngressos.controller.form.AtualizacaoEventoForm;
import com.example.vendaIngressos.controller.form.EventoForm;
import com.example.vendaIngressos.model.Evento;
import com.example.vendaIngressos.repository.EventoRepository;

@Service
public class EventoService {

	@Autowired
	private EventoRepository eventoRepository;

	@Autowired
	private UsuarioService usuarioService;

	public Page<EventoDto> lista(Pageable paginacao) {
		Page<Evento> eventos = eventoRepository.findAll(paginacao);
		return EventoDto.converter(eventos);
	}

	public Evento insere(EventoForm form) {
		Evento evento = form.converter(usuarioService);
		evento.atualizaCapacidade();
		eventoRepository.save(evento);

		return evento;
	}

	public ResponseEntity<EventoDto> atualiza(Long id, AtualizacaoEventoForm form) {
		Optional<Evento> optional = eventoRepository.findById(id);
		if (optional.isPresent()) {
			Evento evento = form.atualizar(id, eventoRepository);
			return ResponseEntity.ok(new EventoDto(evento));
		}

		return ResponseEntity.notFound().build();
	}

	public ResponseEntity<?> deleta(Long id) {
		Optional<Evento> optional = eventoRepository.findById(id);
		if (optional.isPresent()) {
			eventoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();
	}

	public Evento getOne(Long idEvento) {
		return eventoRepository.getOne(idEvento);
	}

}
