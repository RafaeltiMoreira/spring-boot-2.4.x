package com.rafaelmoreira.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rafaelmoreira.spring.entities.ClientCategory;

@Repository
public interface ClientRepository extends JpaRepository<ClientCategory, Long> {

}
