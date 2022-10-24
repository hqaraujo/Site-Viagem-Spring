package br.com.bonvoyage.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import br.com.bonvoyage.model.Destino;

public interface DestinoRepository extends JpaRepository<Destino, Long> {
	
}