package org.VentaBoleto.repository;


import org.VentaBoleto.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepository extends JpaRepository<Cliente, Integer> {
	Cliente findByIdCliente(Integer IdCliente);
}
