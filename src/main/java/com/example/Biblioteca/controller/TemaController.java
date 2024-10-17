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

import com.example.Biblioteca.model.TemaModel;
import com.example.Biblioteca.service.TemaService;

@RestController
@RequestMapping(value="/tema")
public class TemaController {

	@Autowired
	TemaService temaService;
	
	@PostMapping(value="/save")
	public TemaModel addTema(@RequestBody TemaModel tema) {
		TemaModel result = new TemaModel();
		
		result = temaService.addTema(tema);
		
		return result;
	}
	
	@GetMapping(value="/getAll")
	public ArrayList<TemaModel> getAllTemas(){
		ArrayList<TemaModel> result = new ArrayList<>();
		
		result = temaService.getAllTemas();
		
		return result;
	}
	
	@GetMapping(value="/get/{id}")
	public TemaModel getTemaById(@PathVariable(value="id") Integer id) {
		TemaModel result = new TemaModel();
		
		result = temaService.getTemaById(id);
		
		return result;
	}
	
	@GetMapping(value="/getByFilter")
	public ArrayList<TemaModel> getTemasByFilter(TemaModel filter){
		ArrayList<TemaModel> result = new ArrayList<>();
		
		result = temaService.getTemasByFilter(filter);
		
		return result;
	}
	
	@PutMapping(value="/update/{id}")
	public TemaModel updateTema(@PathVariable(value="id") Integer id, @RequestBody TemaModel update) {
		TemaModel result = new TemaModel();
		
		result = temaService.updateTema(id, update);
		
		return result;
		
	}
	
	@DeleteMapping(value="/delete/{id}")
	public Boolean deleteTema (@PathVariable(value="id") Integer id) {
		Boolean result = false;
		
		result = temaService.deleteTema(id);
		
		return result;
	}
}
