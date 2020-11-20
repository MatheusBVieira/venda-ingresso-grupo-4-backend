package com.example.vendaIngressos.controller.dto;

import org.springframework.data.domain.Page;

import com.example.vendaIngressos.model.Endereco;
import com.example.vendaIngressos.model.Usuario;

public class UsuarioDto {

	private Long id;
	private String nomeCompleto;
	private String cpf;
	private Endereco endereco;
	private String username;
	private String email;
	private String telefone;
	private int idade;

	public UsuarioDto(Usuario usuario) {
		this.id = usuario.getId();
		this.nomeCompleto = usuario.getNomeCompleto();
		this.cpf = usuario.getCpf();
		this.endereco = usuario.getEndereco();
		this.username = usuario.getUsername();
		this.email = usuario.getEmail();
		this.telefone = usuario.getTelefone();
		this.idade = usuario.getIdade();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public static Page<UsuarioDto> converter(Page<Usuario> usuarios) {
		return usuarios.map(UsuarioDto::new);
	}

}
