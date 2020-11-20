package com.example.vendaIngressos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.vendaIngressos.model.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long> {

}
