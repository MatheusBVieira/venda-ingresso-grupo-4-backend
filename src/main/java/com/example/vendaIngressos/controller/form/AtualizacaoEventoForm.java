package com.example.vendaIngressos.controller.form;

import java.util.Date;

import com.example.vendaIngressos.model.Categoria;
import com.example.vendaIngressos.model.Endereco;
import com.example.vendaIngressos.model.Evento;
import com.example.vendaIngressos.repository.EventoRepository;
import com.fasterxml.jackson.annotation.JsonFormat;

public class AtualizacaoEventoForm {

	private String nome;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date data;
	private Double preco;
	private Categoria categoria;
	private Endereco endereco;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
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

	public Evento atualizar(Long id, EventoRepository eventoRepository) {
		Evento evento = eventoRepository.getOne(id);

		evento.setNome(this.nome);
		evento.setData(this.data);
		evento.setPreco(this.preco);
		evento.setCategoria(this.categoria);
		evento.setEndereco(endereco);

		return evento;
	}

}
