package com.example.Biblioteca.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MiController {
	
	@GetMapping("/hola")
	public String hola() {
		return "Hola";
	}
}
