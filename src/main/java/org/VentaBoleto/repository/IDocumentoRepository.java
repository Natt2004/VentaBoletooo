package org.VentaBoleto.repository;

import org.VentaBoleto.model.Documento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDocumentoRepository extends JpaRepository<Documento, Integer> {
		Documento findByIdDoc (Integer IdDoc);
}
