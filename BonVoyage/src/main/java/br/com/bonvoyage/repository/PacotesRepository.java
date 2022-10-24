package br.com.bonvoyage.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import br.com.bonvoyage.model.Pacotes;

public interface PacotesRepository extends JpaRepository<Pacotes, Long> {
	
	
}