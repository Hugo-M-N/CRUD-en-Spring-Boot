package com.example.Biblioteca.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class PaginaController {

	@GetMapping(value="/")
	public String index() {
		return "index";
	}
	
	@GetMapping(value="/dashboard")
	public String dashboard() {
		return "dashboard";
	}
	
}