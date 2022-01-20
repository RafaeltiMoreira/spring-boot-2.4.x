package com.rafaelmoreira.spring.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rafaelmoreira.spring.dto.ClientDTO;
import com.rafaelmoreira.spring.entities.ClientCategory;
import com.rafaelmoreira.spring.repositories.ClientRepository;
import com.rafaelmoreira.spring.services.exceptions.EntityNotFoundException;

@Service 
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	@Transactional(readOnly = true)
	public List<ClientDTO> findAll() {
		List<ClientCategory> list = repository.findAll();
		
		return list.stream().map(x -> new ClientDTO(x)).collect(Collectors.toList());
		
		/*List<ClientDTO> listDto = new ArrayList<>();
		for (ClientCategory cat : list) {
			listDto.add(new ClientDTO(cat));
		}*/
		
		//return listDto;
	}

	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Optional<ClientCategory> obj = repository.findById(id);
		ClientCategory entity = obj.orElseThrow(() -> new EntityNotFoundException("Entity não encontrada."));
		return new ClientDTO(entity);
	}

}
