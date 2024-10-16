package com.example.Biblioteca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Biblioteca.model.LibroModel;
import com.example.Biblioteca.service.LibroService;

@RestController
@RequestMapping(value = "/libro")
public class LibroController {

	@Autowired
	LibroService libroService;
	
	@PostMapping(value = "/save")
	public LibroModel guardaLibro(@RequestBody LibroModel libro) {
		LibroModel result = new LibroModel();
		
		result = libroService.guardaLibro(libro);
		
		return result;
	}
	
	@GetMapping(value = "/get/{id}")
	public LibroModel getLibro(@PathVariable(value = "id") Integer id){
		LibroModel result = new LibroModel();
		
		result = libroService.getLibroById(id);
		
		return result;
	}
	
	@PutMapping(value="/update/{id}")
	public LibroModel updateLibro(@PathVariable(value="id") Integer id, @RequestBody LibroModel update) {
		LibroModel result = new LibroModel();
		
		result = libroService.updateLibro(id, update);
		
		return result;
		
	}
	
	@DeleteMapping(value="/delete/{id}")
	public Boolean deleteLibro (@PathVariable(value="id") Integer id) {
		Boolean result = false;
		
		result = libroService.deleteLibro(id);
		
		return result;
	}
}
