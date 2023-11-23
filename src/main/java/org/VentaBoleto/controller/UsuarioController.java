package org.VentaBoleto.controller;

import org.VentaBoleto.model.Usuario;
import org.VentaBoleto.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path ="/Usuario")
public class UsuarioController {
	@Autowired
	private IUsuarioRepository repo;
	
	@GetMapping("/Index")
	public String listadoProducto(Model model) {
		model.addAttribute("lstUsuarios", repo.findAll());
		return "Usuario/IndexUsuario";
	}
	
	@GetMapping("/registrarse")
	public String cargarReg(Model model) {
			Usuario usuario = new Usuario();
			model.addAttribute("usuario", usuario );
			
		
		return "Usuario/Registro";
	}
	@PostMapping("/grabar")
	public String grabarPag(@ModelAttribute Usuario usuario) {
		repo.save(usuario);
		return "Usuario/IndexUsuario";
	}
	
	@GetMapping("/editar/{codigo}")
	public String editar(@ModelAttribute Usuario usuario, Model model) {
		model.addAttribute("usuario",usuario.getIdUsuario());
		return "Usuario/Editar";
	}
	@PostMapping("/actualizar")
	public String actualizarPag(@ModelAttribute Usuario usuario) {
		repo.save(usuario);
		return "actualizardo";
	}
	@PostMapping("/eliminar")
	public String eliminar(@ModelAttribute Usuario usuario) {
		Usuario usu= repo.findByIdUsuario(usuario.getIdUsuario());
		repo.delete(usu);
		
		return ("redirect:/Index");
	}
}
