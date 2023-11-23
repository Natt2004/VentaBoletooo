package org.VentaBoleto.controller;

import org.VentaBoleto.model.Documento;
import org.VentaBoleto.repository.IDocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path ="Documento")
public class DocumentoController {
	
	
	@Autowired
	private IDocumentoRepository doc;
	
	@GetMapping("/Index")
	public String listadoDocumento(Model model) {
		model.addAttribute("lstDocumentos", doc.findAll());
		return "Documento/Index";
	}
	//Get de create 
		@GetMapping("/registrarse")
		public String cargarReg(Model model) {
			Documento documento = new Documento();
			model.addAttribute("documento",documento);
				return "Documento/Registro";
		}
		//Pos de create
		@PostMapping("/grabar")
		public String grabarPag(@ModelAttribute  Documento documento) {
			doc.save(documento);
			return "Documento/Index";
		}
		//Get de actualizar
		@GetMapping("/editar/{codigo}")
		public String editar(@ModelAttribute Documento documento ,Model model) {	
			model.addAttribute("documento",documento.getIdDoc());
			return "Documento/Editar";
		}
		
		
		
		//Post de Actualizar
		@PostMapping("/actualizar")
		public String actualizarPag(@ModelAttribute Documento documento ) {
			doc.save(documento);
			return "actualizado";
		}
		
		@PostMapping("/eliminar")
		public String eliminar(@ModelAttribute Documento documento ) {
			Documento docu = doc.findByIdDoc(documento.getIdDoc());	
			doc.delete(docu);
			return ("redirect:/Index");
		}

	

}
