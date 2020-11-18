package com.example.vendaIngressos.controller.form;

import com.example.vendaIngressos.model.Endereco;
import com.example.vendaIngressos.model.Usuario;
import com.example.vendaIngressos.repository.UsuarioRepository;

public class AtualizacaoUsuarioForm {

	public String nomeCompleto;
	public Endereco endereco;
	public String password;
	public String email;
	public String telefone;
	public int idade;

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Usuario atualizar(Long id, UsuarioRepository usuarioRepository) {
		Usuario usuarioBanco = usuarioRepository.getOne(id);

		usuarioBanco.setNomeCompleto(this.nomeCompleto);
		usuarioBanco.setEndereco(endereco);
		usuarioBanco.setPassword(password);
		usuarioBanco.setEmail(email);
		usuarioBanco.setTelefone(telefone);
		usuarioBanco.setIdade(idade);

		return usuarioBanco;
	}

}
