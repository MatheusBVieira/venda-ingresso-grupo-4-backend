package com.example.vendaIngressos.controller.form;

import java.util.Date;

import com.example.vendaIngressos.model.Compra;
import com.example.vendaIngressos.model.Evento;
import com.example.vendaIngressos.model.Usuario;
import com.example.vendaIngressos.service.EventoService;
import com.example.vendaIngressos.service.UsuarioService;

public class CompraForm {

	private Long idEvento;

	public Long getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(Long idEvento) {
		this.idEvento = idEvento;
	}

	public Compra converter(Long comprador, UsuarioService usuarioService, EventoService eventoService) {
		Usuario usuario = usuarioService.getOne(comprador).get();
		Evento evento = eventoService.getOne(idEvento).get();
		Date date = new Date();

		return new Compra(usuario, evento, date);
	}

}
