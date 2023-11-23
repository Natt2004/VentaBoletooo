package org.VentaBoleto.controller;

import org.VentaBoleto.model.Boleto;
import org.VentaBoleto.repository.IAreolineaRepository;
import org.VentaBoleto.repository.IBoletoRepository;
import org.VentaBoleto.repository.IClienteRepository;
import org.VentaBoleto.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path ="/Boleto")
public class BoletoController {

	
	@Autowired
	private IBoletoRepository bol;
	@Autowired
	private IUsuarioRepository usu;
	@Autowired
	private IClienteRepository clie;
	@Autowired
	private IAreolineaRepository aero;
	
	
	
	
	//Listar
	@GetMapping("/Index")
	public String listadoClientes(Model model) {
		model.addAttribute("lstBoleto", bol.findAll());
		return "Boleto/Index";
	}
	//Get de create 
	@GetMapping("/registrarse")
	public String cargarReg(Model model) {
		Boleto boleto = new Boleto();
		model.addAttribute("boleto",boleto);
		model.addAttribute("lstUsuario", usu.findAll());
		model.addAttribute("lstCliente", clie.findAll());
		model.addAttribute("lstAerolinea", aero.findAll());
		return "Boleto/Registro";
	}
	//Pos de create
	@PostMapping("/grabar")
	public String grabarPag(@ModelAttribute Boleto boleto) {
		bol.save(boleto);
		return "Boleto/Index";
	}
	//Get de actualizar
	@GetMapping("/editar/{codigo}")
	public String editar(@ModelAttribute Boleto boleto,Model model) {	
		model.addAttribute("boleto", boleto.getID());
		model.addAttribute("lstUsuario", usu.findAll());
		model.addAttribute("lstCliente", clie.findAll());
		model.addAttribute("lstAerolinea", aero.findAll());
		return "Boleto/Editar";
	}
	
	
	
	//Post de Actualizar
	@PostMapping("/actualizar")
	public String actualizarPag(@ModelAttribute Boleto boleto) {
		bol.save(boleto);
		return "actualizado";
	}
	
	@PostMapping("/eliminar")
	public String eliminar(@ModelAttribute Boleto boleto) {
		Boleto blt= bol.findByID(boleto.getID());
		
		bol.delete(blt);
		return ("redirect:/Index");
	}
	
}
