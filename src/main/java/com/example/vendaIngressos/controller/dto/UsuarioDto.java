package com.example.vendaIngressos.controller.dto;

import org.springframework.data.domain.Page;

import com.example.vendaIngressos.model.Usuario;

public class UsuarioDto {

	private Long id;
	private String nome;
	private String sobrenome;
	private String cpf;
	private String email;
	private String telefone;

	public UsuarioDto(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.sobrenome = usuario.getSobrenome();
		this.cpf = usuario.getCpf();
		this.email = usuario.getEmail();
		this.telefone = usuario.getTelefone();
	}

	public static Page<UsuarioDto> converter(Page<Usuario> usuarios) {
		return usuarios.map(UsuarioDto::new);
	}

	public static UsuarioDto converter(Usuario usuario) {
		return new UsuarioDto(usuario);
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

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

}
