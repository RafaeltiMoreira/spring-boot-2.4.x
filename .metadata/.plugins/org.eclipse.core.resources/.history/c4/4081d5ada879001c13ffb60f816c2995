package com.rafaelmoreira.spring.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafaelmoreira.spring.entities.ClientCategory;
import com.rafaelmoreira.spring.services.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {
	
	@Autowired
	private ClientService service;
	
	public ResponseEntity<List<ClientCategory>> findAll() {
		List<ClientCategory> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
}
