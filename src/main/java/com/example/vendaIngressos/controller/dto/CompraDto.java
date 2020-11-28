package com.example.vendaIngressos.controller.dto;

import org.springframework.data.domain.Page;

import com.example.vendaIngressos.model.Compra;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class CompraDto {

	private Long idUsuario;
	private Long idEvento;
	private String dataDeCompra;

	public CompraDto(Compra compra) {
		this.idUsuario = compra.getUsuario().getId();
		this.idEvento = compra.getEvento().getId();
		this.dataDeCompra = compra.getDataDeCompra();
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Long getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(Long idEvento) {
		this.idEvento = idEvento;
	}

	public String getDataDeCompra() {
		return dataDeCompra;
	}

	public void setDataDeCompra(String dataDeCompra) {
		this.dataDeCompra = dataDeCompra;
	}

	public static Page<CompraDto> converter(Page<Compra> compras) {
		return compras.map(CompraDto::new);
	}

}
