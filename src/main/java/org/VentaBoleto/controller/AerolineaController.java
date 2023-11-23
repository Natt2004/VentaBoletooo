package org.VentaBoleto.controller;

import org.VentaBoleto.model.Aerolinea;
import org.VentaBoleto.repository.IAreolineaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path ="/Aerolinea")
public class AerolineaController {

	
	
	@Autowired
	private IAreolineaRepository aero;
	
	
	//listar
	@GetMapping("/Index")
	public String listadoAerolinea(Model model) {
		model.addAttribute("lstAerolineas", aero.findAll());
		return "Aerolinea/Index";
	}
	
	//Get de create 
		@GetMapping("/registrarse")
		public String cargarReg(Model model) {
				Aerolinea aerolinea = new Aerolinea();
				model.addAttribute("Aerolinea", aerolinea);
				return "Aerolinea/Registro";
		}
		//Pos de create
		@PostMapping("/grabar")
		public String grabarPag(@ModelAttribute Aerolinea aerolinea ) {
			aero.save(aerolinea);
			return "Aerolinea/Index";
		}
		//Get de actualizar
		@GetMapping("/editar/{codigo}")
		public String editar(@ModelAttribute Aerolinea aerolinea ,Model model) {	
			model.addAttribute("aerolinea", aerolinea.getId());
			return "Aerolinea/Editar";
		}
		
		
		
		//Post de Actualizar
		@PostMapping("/actualizar")
		public String actualizarPag(@ModelAttribute Aerolinea aerolinea ) {
			aero.save(aerolinea);
			return "actualizado";
		}
		
		@PostMapping("/eliminar")
		public String eliminar(@ModelAttribute Aerolinea aerolinea ) {
			Aerolinea ae= aero.getById(aerolinea.getId());		
			aero.delete(ae);
			return ("redirect:/Index");
		}

	
	
	
	
}
