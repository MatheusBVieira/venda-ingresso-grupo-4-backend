package com.example.vendaIngressos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.vendaIngressos.model.DataEvento;

public interface DataRepository extends JpaRepository<DataEvento, Long> {

}
