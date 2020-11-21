package com.example.vendaIngressos.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.vendaIngressos.controller.dto.CompraDto;
import com.example.vendaIngressos.controller.dto.CompraDto;
import com.example.vendaIngressos.controller.form.AtualizacaoUsuarioForm;
import com.example.vendaIngressos.controller.form.CompraForm;
import com.example.vendaIngressos.model.Compra;
import com.example.vendaIngressos.model.Usuario;
import com.example.vendaIngressos.model.Compra;
import com.example.vendaIngressos.repository.UsuarioRepository;

@Service
public class CompraService<AtualizacaoCompraForm> {
	
	@Autowired
	private static UsuarioRepository compraRepository;
	private JpaRepository<Compra, Long> compraRepository;

	public Page<CompraDto> lista(Pageable paginacao) {
		Page<Usuario> compras = compraRepository.findAll(paginacao);
		return CompraDto.converter(compras);
	}

	public static <S> Compra insere(CompraForm form) {
		Compra compra = form.converter();
		compraRepository.saveAll((S) compra);
		return compra;
	}

	
	

	public ResponseEntity<?> deleta(String cpf) {
		Optional<Compra> optional = Optional.empty();
		if (optional.isPresent()) {
			compraRepository.deleteAll();
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();
	}

}
