package br.com.bonvoyage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bonvoyage.model.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Long> { 
	

}