package com.example.vendaIngressos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vendaIngressos.model.DataEvento;
import com.example.vendaIngressos.repository.DataRepository;

@Service
public class DataService {

	@Autowired
	private DataRepository dataRepository;

	public DataEvento insere(DataEvento dataEvento) {
		return dataRepository.save(dataEvento);
	}

}
