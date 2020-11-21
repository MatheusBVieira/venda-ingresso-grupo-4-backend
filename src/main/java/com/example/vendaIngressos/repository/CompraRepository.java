package com.example.vendaIngressos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.vendaIngressos.model.Compra;

public interface CompraRepository extends JpaRepository<Compra, Long>{
	
	Optional<Compra> findByCpf(String cartao);


}
