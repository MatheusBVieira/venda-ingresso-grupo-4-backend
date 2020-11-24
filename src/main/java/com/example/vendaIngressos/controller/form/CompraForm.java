package com.example.vendaIngressos.controller.form;

import java.util.Date;

import com.example.vendaIngressos.model.Compra;
import com.example.vendaIngressos.model.Evento;
import com.example.vendaIngressos.model.Usuario;
import com.example.vendaIngressos.service.EventoService;
import com.example.vendaIngressos.service.UsuarioService;

public class CompraForm {

	private Long idUsuario;
	private Long idEvento;

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Long getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(Long idEvento) {
		this.idEvento = idEvento;
	}

	public Compra converter(UsuarioService usuarioService, EventoService eventoService) {

		Usuario usuario = usuarioService.getOne(idUsuario);
		Evento evento = eventoService.getOne(idEvento);

		Date date = new Date();

		return new Compra(usuario, evento, date);
	}

}
