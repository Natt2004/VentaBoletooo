package org.VentaBoleto.repository;



import java.util.Optional;

import org.VentaBoleto.model.Destino;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDestinoRepository extends JpaRepository<Destino, Integer> {
	Optional<Destino> findById(Integer Id);
}
