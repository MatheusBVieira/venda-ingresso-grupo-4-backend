package com.example.vendaIngressos.model;

import java.text.SimpleDateFormat;
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

	public Compra(Usuario usuario, Evento evento, Date dataDeCompra) {
		this.usuario = usuario;
		this.evento = evento;
		this.dataDeCompra = dataDeCompra;
	}

	public Compra() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getDataDeCompra() {
		return new SimpleDateFormat("dd/MM/yyyy").format(dataDeCompra);
	}

	public void setDataDeCompra(Date dataDeCompra) {
		this.dataDeCompra = dataDeCompra;
	}

}
