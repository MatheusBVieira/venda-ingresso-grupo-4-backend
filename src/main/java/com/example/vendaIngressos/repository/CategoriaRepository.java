package com.example.vendaIngressos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.vendaIngressos.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
