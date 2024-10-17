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

import com.example.Biblioteca.model.EjemplarModel;
import com.example.Biblioteca.service.EjemplarService;

@RestController
@RequestMapping(value="/ejemplar")
public class EjemplarController {

	@Autowired
	EjemplarService ejemplarService;
	
	@PostMapping(value="/save")
	public EjemplarModel addEjemplar(@RequestBody EjemplarModel ejemplar) {
		EjemplarModel result = new EjemplarModel();
		
		result = ejemplarService.addEjemplar(ejemplar);
		
		return result;
	}
	
	@GetMapping(value="/getAll")
	public ArrayList<EjemplarModel> getAllEjemplares(){
		ArrayList<EjemplarModel> result = new ArrayList<>();
		
		result = ejemplarService.getAllEjemplares();
		
		return result;
	}
	
	@GetMapping(value="/get/{id}")
	public EjemplarModel getEjemplarById(@PathVariable(value="id") Integer id) {
		EjemplarModel result = new EjemplarModel();
		
		result = ejemplarService.getEjemplarById(id);
		
		return result;
	}
	
	@GetMapping(value="/getByFilter")
	public ArrayList<EjemplarModel> getEjemplaresByFilter(@RequestBody EjemplarModel filter){
		ArrayList<EjemplarModel> result = new ArrayList<>();
		
		result = ejemplarService.getEjemplaresByFilter(filter);
		
		return result;
	}
	
	@PutMapping(value="/update/{id}")
	public EjemplarModel updateLibro(@PathVariable(value="id") Integer id, @RequestBody EjemplarModel update) {
		EjemplarModel result = new EjemplarModel();
		
		result = ejemplarService.updateEjemplar(id, update);
		
		return result;
		
	}
	
	@DeleteMapping(value="/delete/{id}")
	public Boolean deleteejemplar (@PathVariable(value="id") Integer id) {
		Boolean result = false;
		
		result = ejemplarService.deleteEjemplar(id);
		
		return result;
	}
}
