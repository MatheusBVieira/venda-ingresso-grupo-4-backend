package com.example.vendaIngressos.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.vendaIngressos.model.Compra;

public interface CompraRepository extends JpaRepository<Compra, Long> {

	@Query("SELECT c FROM Compra c WHERE c.usuario.id = :id")
	Page<Compra> findByUsuarioId(@Param("id") Long id, Pageable paginacao);

}
