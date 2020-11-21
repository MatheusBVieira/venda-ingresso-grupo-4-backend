package com.example.vendaIngressos.controller;

import java.net.URI;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.vendaIngressos.controller.dto.CompraDto;
import com.example.vendaIngressos.controller.form.CompraForm;
import com.example.vendaIngressos.model.Compra;
import com.example.vendaIngressos.service.CompraService;


public class CompraController {
	
	private Compra compra;
	private CompraController compraService;
	
	
	@GetMapping
	public Page<CompraDto> lista(
			@PageableDefault(sort = "cpf", direction = Direction.DESC, page = 0, size = 10) Pageable paginacao) {

		compraService = null;
		return compraService.lista(paginacao);
	}

	@PostMapping
	@Transactional
	public ResponseEntity<CompraDto> cadastrar(@RequestBody @Valid CompraForm form, UriComponentsBuilder uriBuilder) {
		Compra compra = CompraService.insere(form);

		URI uri = uriBuilder.path("/compra/{cpf}").buildAndExpand(compra.getCpf()).toUri();
		return ResponseEntity.created(uri).body(new CompraDto(compra));
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}
	
}
