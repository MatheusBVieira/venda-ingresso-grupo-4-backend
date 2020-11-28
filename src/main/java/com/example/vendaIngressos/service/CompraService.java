package com.example.vendaIngressos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.vendaIngressos.controller.dto.CompraDto;
import com.example.vendaIngressos.controller.form.CompraForm;
import com.example.vendaIngressos.model.Compra;
import com.example.vendaIngressos.repository.CompraRepository;

@Service
public class CompraService {

	@Autowired
	private CompraRepository compraRepository;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private EventoService eventoService;

	public Page<CompraDto> lista(Pageable paginacao) {
		Page<Compra> compras = compraRepository.findAll(paginacao);
		return CompraDto.converter(compras);
	}

	public Compra insere(CompraForm form, long comprador) {
		Compra compra = form.converter(comprador, usuarioService, eventoService);

		compraRepository.save(compra);

		return compra;
	}

}
