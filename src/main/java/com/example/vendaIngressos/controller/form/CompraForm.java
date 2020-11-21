package com.example.vendaIngressos.controller.form;

import com.example.vendaIngressos.model.Compra;
import com.example.vendaIngressos.model.Endereco;

public class CompraForm {
	

	public String cartao;
	public String cpf;
	public Endereco endereco;
	public String username;
	public String password;
	
	
	public String getCartao() {
		return cartao;
	}
	public void setCartao(String cartao) {
		this.cartao = cartao;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Compra converter() {
		return new Compra(cartao, cpf, endereco, username, password);
	}
	
}

