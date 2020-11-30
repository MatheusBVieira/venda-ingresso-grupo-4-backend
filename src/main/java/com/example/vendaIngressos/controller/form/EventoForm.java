package com.example.vendaIngressos.controller.form;

import java.io.IOException;

import com.example.vendaIngressos.model.Categoria;
import com.example.vendaIngressos.model.DataEvento;
import com.example.vendaIngressos.model.Endereco;
import com.example.vendaIngressos.model.Evento;
import com.example.vendaIngressos.model.Usuario;
import com.example.vendaIngressos.service.CategoriaService;
import com.example.vendaIngressos.service.DataService;
import com.example.vendaIngressos.service.ImagemService;
import com.example.vendaIngressos.service.UsuarioService;

import org.springframework.web.multipart.MultipartFile;

public class EventoForm {

	private String nome;
	private DataEvento dataEvento;
	private Double preco;
	private Long categoria;
	private Endereco endereco;
	private Integer capacidadePessoas;
	private String descricao;
	private MultipartFile imagem;

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

	public Evento converter(Long criador, UsuarioService usuarioService, DataService dataService,
			CategoriaService categoriaService, ImagemService imagemService) throws IOException {

		Usuario usuario = usuarioService.getOne(criador).get();
		Categoria categoria = categoriaService.getOne(this.categoria).get();
		DataEvento dataInserida = dataService.insere(dataEvento);
		String imagemName = imagemService.insere(imagem).getName();

		return new Evento(nome, usuario, preco, categoria, endereco, dataInserida, capacidadePessoas, descricao,
				imagemName);
	}

	public MultipartFile getImagem() {
		return imagem;
	}

	public void setImagem(MultipartFile imagem) {
		this.imagem = imagem;
	}

}
