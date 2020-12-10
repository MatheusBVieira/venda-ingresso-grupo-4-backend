package com.example.vendaIngressos.controller;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vendaIngressos.controller.dto.CompraDto;
import com.example.vendaIngressos.controller.form.CompraForm;
import com.example.vendaIngressos.model.Compra;
import com.example.vendaIngressos.service.CompraService;
import com.example.vendaIngressos.service.UsuarioService;

@RestController
@RequestMapping("/compra")
public class CompraController {

	@Autowired
	private CompraService compraService;

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping
	public Page<CompraDto> lista(HttpServletRequest request,
			@PageableDefault(sort = "dataDeCompra", direction = Direction.DESC, page = 0, size = 10) Pageable paginacao) {

		return compraService.lista(paginacao, usuarioService.getIdUsuarioWithToken(request));
	}

	@PostMapping
	@Transactional
	public ResponseEntity<CompraDto> cadastrar(@RequestBody @Valid CompraForm form, HttpServletRequest request) {
		Compra compra = compraService.insere(form, usuarioService.getIdUsuarioWithToken(request));
		return ResponseEntity.ok(new CompraDto(compra));
	}

}
