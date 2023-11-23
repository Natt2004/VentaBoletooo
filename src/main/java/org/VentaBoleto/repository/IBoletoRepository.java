package org.VentaBoleto.repository;

import org.VentaBoleto.model.Boleto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBoletoRepository extends JpaRepository<Boleto, Long> {
	Boleto findByID(Long id);
}
