package com.example.vendaIngressos.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Compra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Usuario usuario;

	@ManyToOne
	private Evento evento;
	private Date dataDeCompra;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Date getDataDeCompra() {
		return dataDeCompra;
	}

	public void setDataDeCompra(Date dataDeCompra) {
		this.dataDeCompra = dataDeCompra;
	}

}
