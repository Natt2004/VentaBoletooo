package org.VentaBoleto.controller;

import org.VentaBoleto.model.Destino;
import org.VentaBoleto.repository.IDestinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path ="/Destino")
public class DestinoController {

	
	@Autowired
	private IDestinoRepository des;
	
	
	
	@GetMapping("/Index")
	public String listadoDestinos(Model model) {
		model.addAttribute("lstDestinos", des.findAll());
		return "Destino/Index";
	}
	
	//Get de create 
		@GetMapping("/registrarse")
		public String cargarReg(Model model) {
			Destino destino= new Destino();
			model.addAttribute("destino",destino);
				return "Destino/Registro";
		}
		//Pos de create
		@PostMapping("/grabar")
		public String grabarPag(@ModelAttribute Destino destino) {
			des.save(destino);
			return "Destino/Index";
		}
		//Get de actualizar
		@GetMapping("/editar/{codigo}")
		public String editar(@ModelAttribute Destino destino,Model model) {	
			model.addAttribute("destino",destino.getId() );
			return "Destino/Editar";
		}
		
		
		
		//Post de Actualizar
		@PostMapping("/actualizar")
		public String actualizarPag(@ModelAttribute Destino destino ) {
			
			des.save(destino);
			return "actualizado";
		}
		
		@PostMapping("/eliminar")
		public String eliminar(@ModelAttribute Destino destino ) {
			Destino desti = des.getById(destino.getId());
			des.delete(desti);
			return ("redirect:/Index");
		}

	
}
