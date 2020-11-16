package com.example.vendaIngressos.model;

import java.util.ArrayList;
import java.util.Date;

public class Evento {

	public String nome;
	public Date data;
	public Usuario criador;
	public ArrayList<Usuario> compradores;
	public Double preco;
	public Categoria categoria;
	public Endereco endereco;
	public Integer capacidadePessoas;

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

	public Usuario getCriador() {
		return criador;
	}

	public void setCriador(Usuario criador) {
		this.criador = criador;
	}

	public ArrayList<Usuario> getCompradores() {
		return compradores;
	}

	public void setCompradores(ArrayList<Usuario> compradores) {
		this.compradores = compradores;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

}
