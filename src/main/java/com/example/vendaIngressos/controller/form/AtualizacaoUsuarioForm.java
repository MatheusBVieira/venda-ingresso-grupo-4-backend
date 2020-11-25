package com.example.vendaIngressos.controller.form;

import com.example.vendaIngressos.model.Usuario;
import com.example.vendaIngressos.repository.UsuarioRepository;

public class AtualizacaoUsuarioForm {

	private String nome;
	private String sobrenome;
	private String password;
	private String email;
	private String telefone;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Usuario atualizar(Long id, UsuarioRepository usuarioRepository) {
		Usuario usuarioBanco = usuarioRepository.getOne(id);

		usuarioBanco.setNome(nome);
		usuarioBanco.setSobrenome(sobrenome);
		usuarioBanco.setPassword(password);
		usuarioBanco.setEmail(email);
		usuarioBanco.setTelefone(telefone);

		return usuarioBanco;
	}

}
