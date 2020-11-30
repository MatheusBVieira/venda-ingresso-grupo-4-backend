package com.example.vendaIngressos.repository;

import java.util.Optional;

import com.example.vendaIngressos.model.Imagem;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ImagemRepository extends JpaRepository<Imagem, Long> {

  Optional<Imagem> findByName(String name);

}
