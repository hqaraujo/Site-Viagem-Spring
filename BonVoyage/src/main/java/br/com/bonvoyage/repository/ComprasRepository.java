package br.com.bonvoyage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bonvoyage.model.Compras;

public interface ComprasRepository extends JpaRepository<Compras, Long> {

}