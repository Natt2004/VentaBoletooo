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
@RequestMapping(path ="/")
public class LoginController {

	
	@Autowired
	private IUsuarioRepository repou;
	
	
	
	@GetMapping("/")
	public String cargarPag(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "Index";
	}
	
	@GetMapping("/registrarse")
	public String cargarReg(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "Registro";
	}
	
	@PostMapping("/grabar")
	public String grabarPag(@ModelAttribute Usuario usuario) {
		repou.save(usuario);
		return "Index";
	}
	
	@PostMapping("/validar")
	public String grabarPag(@ModelAttribute Usuario  usuario, Model model ) {
		System.out.println(usuario);
		Usuario u = repou.findByCorreoAndPassword(usuario.getCorreo(), usuario.getPassword());
		System.out.println(u);
		// Validacion 
		if (u == null) {
			model.addAttribute("usuario", new Usuario());
			model.addAttribute("mensaje", "Usuario o clave incorrecto");
			return "Index";
		}else {
			model.addAttribute("Usuario", u);
			return "Menu";
		}
		
	}
	
}
