package com.example.vendaIngressos.controller.form;

import com.example.vendaIngressos.model.Categoria;
import com.example.vendaIngressos.model.DataEvento;
import com.example.vendaIngressos.model.Endereco;
import com.example.vendaIngressos.model.Evento;
import com.example.vendaIngressos.model.Usuario;
import com.example.vendaIngressos.service.DataService;
import com.example.vendaIngressos.service.UsuarioService;

public class EventoForm {

	private String nome;
	private DataEvento dataEvento;
	private Long criador;
	private Double preco;
	private Categoria categoria;
	private Endereco endereco;
	private Integer capacidadePessoas;
	private String descricao;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public DataEvento getDataEvento() {
		return dataEvento;
	}

	public void setDataEvento(DataEvento dataEvento) {
		this.dataEvento = dataEvento;
	}

	public Long getCriador() {
		return criador;
	}

	public void setCriador(Long criador) {
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

	public Integer getCapacidadePessoas() {
		return capacidadePessoas;
	}

	public void setCapacidadePessoas(Integer capacidadePessoas) {
		this.capacidadePessoas = capacidadePessoas;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Evento converter(UsuarioService usuarioService, DataService dataService) {
		Usuario usuario = usuarioService.getOne(criador).get();
		DataEvento dataInserida = dataService.insere(dataEvento);
		return new Evento(nome, usuario, preco, categoria, endereco, dataInserida, capacidadePessoas, descricao);
	}

}
