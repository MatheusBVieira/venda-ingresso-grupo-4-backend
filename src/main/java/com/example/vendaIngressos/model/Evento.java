package com.example.vendaIngressos.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "evento")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Evento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date data;
	@OneToOne(cascade = CascadeType.ALL)
	private Usuario criador;
	@Enumerated(EnumType.STRING)
	private Categoria categoria;
	@OneToOne(cascade = CascadeType.ALL)
	private Endereco endereco;
	private Integer capacidadePessoas;
	private Double preco;
	private String descricao;

	// @ManyToMany(cascade = CascadeType.ALL)
	// @ElementCollection
	// @JoinTable(name = "evento_compradores", joinColumns = @JoinColumn(name =
	// "evento_id"), inverseJoinColumns = @JoinColumn(name = "usuario_id"))
	// private List<Usuario> compradores;

	public Evento(String nome, Date data, Usuario criador, Double preco, Categoria categoria, Endereco endereco,
			Integer capacidadePessoas, String descricao) {
		this.nome = nome;
		this.data = data;
		this.criador = criador;
		this.preco = preco;
		this.categoria = categoria;
		this.endereco = endereco;
		this.capacidadePessoas = capacidadePessoas;
		this.descricao = descricao;
	}

	public Evento() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCapacidadePessoas() {
		return capacidadePessoas;
	}

	public void setCapacidadePessoas(Integer capacidadePessoas) {
		this.capacidadePessoas = capacidadePessoas;
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

	// public List<Usuario> getCompradores() {
	// return compradores;
	// }
	//
	// public void setCompradores(List<Usuario> compradores) {
	// this.compradores = compradores;
	// }

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void atualizaCapacidade() {
		System.out.println(capacidadePessoas);
		double capacidadeNova = capacidadePessoas * 0.4;
		long capacidadeNovaLong = Math.round(capacidadeNova);
		this.capacidadePessoas = (int) capacidadeNovaLong;

	}

}
