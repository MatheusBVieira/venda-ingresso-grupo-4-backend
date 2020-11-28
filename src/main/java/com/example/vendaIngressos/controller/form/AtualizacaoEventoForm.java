package com.example.vendaIngressos.controller.form;

import com.example.vendaIngressos.model.Categoria;
import com.example.vendaIngressos.model.DataEvento;
import com.example.vendaIngressos.model.Endereco;
import com.example.vendaIngressos.model.Evento;
import com.example.vendaIngressos.repository.EventoRepository;
import com.example.vendaIngressos.service.CategoriaService;

public class AtualizacaoEventoForm {

	private String nome;
	private DataEvento dataEvento;
	private Double preco;
	private Long categoria;
	private Endereco endereco;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Long getCategoria() {
		return categoria;
	}

	public void setCategoria(Long categoria) {
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

	public Evento atualizar(Long id, EventoRepository eventoRepository, CategoriaService categoriaService) {
		Evento evento = eventoRepository.getOne(id);
		Categoria categoria = categoriaService.getOne(this.categoria).get();

		evento.setNome(this.nome);
		evento.setDataEvento(this.dataEvento);
		evento.setPreco(this.preco);
		evento.setCategoria(categoria);
		evento.setEndereco(endereco);

		return evento;
	}

}
