package org.VentaBoleto.repository;

import org.VentaBoleto.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
	Usuario findByCorreoAndPassword(String correo, String password);
	
	Usuario findByIdUsuario(Integer IdUsuario);

}
