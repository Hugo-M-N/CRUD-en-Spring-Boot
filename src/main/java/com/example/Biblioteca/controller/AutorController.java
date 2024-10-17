package com.example.Biblioteca.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Biblioteca.model.AutorModel;
import com.example.Biblioteca.service.AutorService;

@RestController
@RequestMapping(value="/autor")
public class AutorController {

	@Autowired
	AutorService autorService;
	
	@PostMapping(value="/save")
	public AutorModel addAutor(@RequestBody AutorModel autor) {
		AutorModel result = new AutorModel();
		
		result = autorService.addAutor(autor);
		
		return result;
	}
	
	@GetMapping(value="/getAll")
	public ArrayList<AutorModel> getAllAutores(){
		ArrayList<AutorModel> result = new ArrayList<>();
		
		result = autorService.getAllAutores();
		
		return result;
	}
	
	@GetMapping(value="/get/{id}")
	public AutorModel getAutorById(@PathVariable(value="id") Integer id) {
		AutorModel result = new AutorModel();
		
		result = autorService.getAutorById(id);
		
		return result;
	}
	
	@GetMapping(value="/getByFilter")
	public ArrayList<AutorModel> getAutoresByFilter(@RequestBody AutorModel filter){
		ArrayList<AutorModel> result = new ArrayList<>();
		
		result = autorService.getAutoresByFilter(filter);
		
		return result;
	}
	
	@PutMapping(value="/update/{id}")
	public AutorModel updateAutor(@PathVariable(value="id") Integer id, @RequestBody AutorModel update) {
		AutorModel result = new AutorModel();
		
		result = autorService.updateAutor(id, update);
		
		return result;
		
	}
	
	@DeleteMapping(value="/delete/{id}")
	public Boolean deleteAutor (@PathVariable(value="id") Integer id) {
		Boolean result = false;
		
		result = autorService.deleteAutor(id);
		
		return result;
	}
}
