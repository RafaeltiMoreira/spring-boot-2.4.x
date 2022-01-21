package com.rafaelmoreira.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafaelmoreira.spring.entities.ClientCategory;
import com.rafaelmoreira.spring.repositories.ClientRepository;

@Service 
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	public List<ClientCategory> findAll() {
		return repository.findAll();
	}

}
