package br.com.bonvoyage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bonvoyage.model.Login;


public interface LoginRepository extends JpaRepository<Login, Long> {
	
	

}