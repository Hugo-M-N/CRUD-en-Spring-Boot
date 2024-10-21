package com.example.Biblioteca.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Biblioteca.model.UsuarioModel;
import com.example.Biblioteca.service.UsuarioService;

@Controller
@RequestMapping(value="/registro")
public class RegistroController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@GetMapping("")
	public String registro() {
		return "registro";
	}
	
	@PostMapping("")
	public String registarUsuario(
			@RequestParam(name="nombre") String nombre, @RequestParam(name="email") String email, 
			@RequestParam(name="password") String password, @RequestParam(name="password2") String password2, Model model) {
		
		String error = "";
		
		UsuarioModel nuevo = new UsuarioModel();
		ArrayList<UsuarioModel> lista = new ArrayList();
		
		nuevo.setNombre(nombre);
		if(nombre.equals("")) {
			error="El nombre es obligatorio";
			model.addAttribute(error);
			return "registro";
		}
		
		nuevo.setEmail(email);
		
		for(UsuarioModel existe : lista) {
			if(existe.getEmail().equalsIgnoreCase(email)) {
				error = "Email no valido";
				model.addAttribute("error", error);
				return "registro";
			}
		}	

		
		if(!password.equals(password2)) {
			error="Las contraseñas deben ser iguales";
			model.addAttribute("error", error);
			return "registro";
		}
		
		nuevo.setPassword(passwordEncoder.encode(password));
		
		usuarioService.addUsuario(nuevo);
		
		model.addAttribute("registro", "Usuario registado correctamente");
		
		
		
		return "registro";
		
	}
	
}
