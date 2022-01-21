package com.rafaelmoreira.spring.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rafaelmoreira.spring.dto.ClientDTO;
import com.rafaelmoreira.spring.entities.ClientCategory;
import com.rafaelmoreira.spring.repositories.ClientRepository;
import com.rafaelmoreira.spring.services.exceptions.DatabaseException;
import com.rafaelmoreira.spring.services.exceptions.ResourceNotFoundException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;

	@Transactional(readOnly = true)
	public List<ClientDTO> findAll() {
		List<ClientCategory> list = repository.findAll();

		return list.stream().map(x -> new ClientDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Optional<ClientCategory> obj = repository.findById(id);
		ClientCategory entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity não encontrada."));
		return new ClientDTO(entity);
	}

	@Transactional(readOnly = true)
	public ClientDTO insert(ClientDTO dto) {
		ClientCategory entity = new ClientCategory();
		entity.setName(dto.getName());
		entity.setCpf(dto.getCpf());
		entity.setIncome(dto.getIncome());
		entity.setBirthDate(dto.getBirthDate());
		entity.setChildren(dto.getChildren());
		entity = repository.save(entity);
		return new ClientDTO(entity);
	}

	@Transactional
	public ClientDTO update(Long id, ClientDTO dto) {
		try {
			ClientCategory entity = repository.getOne(id);
			entity.setName(dto.getName());
			entity.setCpf(dto.getCpf());
			entity.setIncome(dto.getIncome());
			entity.setBirthDate(dto.getBirthDate());
			entity.setChildren(dto.getChildren());
			entity = repository.save(entity);
			return new ClientDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id não encontrado." + id);
		}
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id não encontrado." + id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Violation de integridade");
		}
	}

}
