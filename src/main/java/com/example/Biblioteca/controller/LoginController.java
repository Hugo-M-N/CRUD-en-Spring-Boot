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
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@GetMapping("")
	public String login() {
		return "login";
	}
	
	@PostMapping("")
	public String checkLogin(@RequestParam(name="email") String email, @RequestParam(name="password") String password, Model model) {
		ArrayList<UsuarioModel> lista = new ArrayList<>();
		UsuarioModel usuario = new UsuarioModel();
		
		usuario.setEmail(email);
		
		lista = usuarioService.getUsuariosByFilter(usuario);
		
		System.out.println(usuario.getEmail());
		System.out.println(lista);
		
		for(UsuarioModel existe : lista) {
			if(existe.getEmail().equalsIgnoreCase(usuario.getEmail())) {
				System.out.println(existe.getEmail());
				if(passwordEncoder.matches(password, existe.getPassword())) {
					System.out.println("a");
					return "redirect:/dashboard";
				}
				System.out.println("b");
				model.addAttribute("error", "Usuario o contraseña incorrectos");
				return "login";
			}
		}
		System.out.println("c");
		model.addAttribute("error", "Usuario o contraseña incorrectos");
		return "login";
		
	}
	
}
