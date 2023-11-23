package org.VentaBoleto.controller;

import org.VentaBoleto.model.Cliente;
import org.VentaBoleto.repository.IClienteRepository;
import org.VentaBoleto.repository.IDocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/Cliente")
public class ClienteController {

	@Autowired
	private IClienteRepository clie;
	@Autowired
	private IDocumentoRepository doc;

	@GetMapping("/Index")
	public String listadoClientes(Model model) {
		model.addAttribute("lstClientes", clie.findAll());
		return "Cliente/Index";
	}

	@GetMapping("/registrarse")
	public String cargarReg(Model model) {
		Cliente cliente = new Cliente();

		model.addAttribute("cliente", cliente);
		model.addAttribute("lstDocumento", doc.findAll());
		return "Cliente/Registro";
	}

	@PostMapping("/grabar")
	public String grabarPag(@ModelAttribute Cliente cliente) {

		clie.save(cliente);

		return "Boleto/Index";
	}
	@GetMapping("/editar/{codigo}")
	public String editar(@ModelAttribute Cliente cliente,Model model) {
		model.addAttribute("cliente", cliente.getIdCliente());
		model.addAttribute("lstDocumento" , doc.findAll());		
		return "Boleto/Editar";
	}
	@PostMapping("/actualizar")
	public String actualizaPag(@ModelAttribute Cliente cliente) {
		clie.save(cliente);
		return "Boleto/Index";
	}
		
	
	@PostMapping("/eliminar")
	public String eliminar(@ModelAttribute Cliente cliente) {
		Cliente client = clie.findByIdCliente(cliente.getIdCliente());
		clie.delete(client);
		return "Boleto/Index";
	}
}
