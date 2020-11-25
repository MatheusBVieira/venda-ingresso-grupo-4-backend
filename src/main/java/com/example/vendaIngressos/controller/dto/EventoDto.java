package com.example.vendaIngressos.controller.dto;

import org.springframework.data.domain.Page;

import com.example.vendaIngressos.model.Categoria;
import com.example.vendaIngressos.model.DataEvento;
import com.example.vendaIngressos.model.Endereco;
import com.example.vendaIngressos.model.Evento;

public class EventoDto {

	private Long id;
	private String nome;
	private DataEvento dataEvento;
	private long criador;
	// private List<Usuario> compradores;
	private Double preco;
	private Categoria categoria;
	private Endereco endereco;
	private Integer capacidadePessoas;
	private String descricao;

	public EventoDto(Evento evento) {
		this.id = evento.getId();
		this.nome = evento.getNome();
		this.dataEvento = evento.getDataEvento();
		this.criador = evento.getCriador().getId();
		// this.compradores = evento.getCompradores();
		this.preco = evento.getPreco();
		this.categoria = evento.getCategoria();
		this.endereco = evento.getEndereco();
		this.capacidadePessoas = evento.getCapacidadePessoas();
		this.descricao = evento.getDescricao();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	// public List<Usuario> getCompradores() {
	// return compradores;
	// }
	//
	// public void setCompradores(List<Usuario> compradores) {
	// this.compradores = compradores;
	// }

	public long getCriador() {
		return criador;
	}

	public void setCriador(long criador) {
		this.criador = criador;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public DataEvento getDataEvento() {
		return dataEvento;
	}

	public void setDataEvento(DataEvento dataEvento) {
		this.dataEvento = dataEvento;
	}

	public Integer getCapacidadePessoas() {
		return capacidadePessoas;
	}

	public void setCapacidadePessoas(Integer capacidadePessoas) {
		this.capacidadePessoas = capacidadePessoas;
	}

	public static Page<EventoDto> converter(Page<Evento> eventos) {
		return eventos.map(EventoDto::new);
	}

	public static EventoDto converter(Evento evento) {
		return new EventoDto(evento);
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
