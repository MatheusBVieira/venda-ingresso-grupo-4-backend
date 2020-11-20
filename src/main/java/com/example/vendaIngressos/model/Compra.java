package com.example.vendaIngressos.model;

//@Entity
public class Compra {

	private Usuario usuario;
	private Evento evento;
	private int quantidadeDeIngressos;

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

	public int getQuantidadeDeIngressos() {
		return quantidadeDeIngressos;
	}

	public void setQuantidadeDeIngressos(int quantidadeDeIngressos) {
		this.quantidadeDeIngressos = quantidadeDeIngressos;
	}

}
