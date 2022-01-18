package com.rafaelmoreira.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafaelmoreira.spring.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
