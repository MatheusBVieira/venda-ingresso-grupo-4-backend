package com.example.vendaIngressos.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.vendaIngressos.model.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long> {

	@Query("SELECT e FROM Evento e WHERE e.nome LIKE %:nome%")
	Page<Evento> findByNome(@Param("nome") String nome, Pageable paginacao);
}
