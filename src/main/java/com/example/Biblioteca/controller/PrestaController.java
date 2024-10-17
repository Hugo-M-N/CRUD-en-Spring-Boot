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

import com.example.Biblioteca.model.PrestaModel;
import com.example.Biblioteca.service.PrestaService;

@RestController
@RequestMapping(value="/presta")
public class PrestaController {
	
	@Autowired
	PrestaService prestaService;
	
	@PostMapping(value="/save")
	public PrestaModel addPresta(@RequestBody PrestaModel presta) {
		PrestaModel result = new PrestaModel();
		
		result = prestaService.addPresta(presta);
		
		return result;
	}
	
	@GetMapping(value="/getAll")
	public ArrayList<PrestaModel> getAllPrestamos(){
		ArrayList<PrestaModel> result = new ArrayList<>();
		
		result = prestaService.getAllPrestamos();
		
		return result;
	}
	
	@GetMapping(value="/get/{id}")
	public PrestaModel getPrestaById(@PathVariable(value="id")Integer id) {
		PrestaModel result = new PrestaModel();
		
		result = prestaService.getPrestaById(id);
		
		return result;
	}
	
	@GetMapping(value="/getByFilter")
	public ArrayList<PrestaModel> getPrestamosByFilter(@RequestBody PrestaModel filter){
		ArrayList<PrestaModel> result = new ArrayList<>();
		
		result = prestaService.getPrestamosByFilter(filter);
		
		return result;
	}
	
	@PutMapping(value="update/{id}")
	public PrestaModel uppdatePresta(@PathVariable(value="id")Integer id, @RequestBody PrestaModel update) {
		PrestaModel result = new PrestaModel();
		
		result = prestaService.updatePresta(id, update);
		
		return result;
	}
	
	@DeleteMapping(value="/delete/{id}")
	public Boolean deletePresta(@PathVariable(value="id")Integer id) {
		Boolean result = false;
		
		result = prestaService.deletePresta(id);
		
		return result;
	}
}
