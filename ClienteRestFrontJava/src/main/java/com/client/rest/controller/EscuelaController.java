package com.client.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.client.rest.model.Escuela;

import com.client.rest.service.EscuelaService;

@Controller
@RequestMapping("/escuela")
public class EscuelaController {

	// necesitamos inyectar nuestro servicio al cliente
	@Autowired
	private EscuelaService escuelaService;
	
	@GetMapping("/list")
	public String listEscuelas(Model theModel) {
		
		// obtener clientes del servicio
		List<Escuela> theEscuelas = escuelaService.getEscuelas();
				
		// agregar los clientes al modelo
		theModel.addAttribute("escuelas", theEscuelas);
		
		return "list-escuelas";
	}
	
	@GetMapping("/mostrarFormularioParaAgregar")
	public String mostrarFormularioParaAgregar(Model theModel) {
		
		// crea el atributo del modelo para vincular los datos del formulario
		Escuela theEscuela = new Escuela();
		
		theModel.addAttribute("escuela", theEscuela);
		
		return "escuela-form";
	}
	
	@PostMapping("/guardarEscuela")
	public String guardarEscuela(@ModelAttribute("Escuela") Escuela theEscuela) {
		
		// guardar al cliente usando nuestro servicio
		escuelaService.saveEscuela(theEscuela);	
		
		return "redirect:/escuela/list";
	}
	
	@GetMapping("/mostrarFormularioParaActualizar")
	public String mostrarFormularioParaActualizar(@RequestParam("escuelaId") int theId,
									Model theModel) {
		
		// obtener al cliente de nuestro servicio
		Escuela theEscuela = escuelaService.getEscuela(theId);	
		
		// establece el cliente como un atributo del modelo para completar previamente el formulario
		theModel.addAttribute("escuela", theEscuela);
		
		// enviar a nuestro formulario	
		return "escuela-form";
	}
	
	@GetMapping("/borrarEscuela")
	public String borrarEscuela(@RequestParam("escuelaId") int theId) {
		
		// eliminar el cliente
		escuelaService.deleteEscuela(theId);
		
		return "redirect:/escuela/list";
	}
}










