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

import com.example.Biblioteca.model.TrataModel;
import com.example.Biblioteca.service.TrataService;

@RestController
@RequestMapping(value="/trata")
public class TrataController {

	@Autowired
	TrataService trataService;
	
	@PostMapping(value="/save")
	public TrataModel addTrata(@RequestBody TrataModel trata) {
		TrataModel result = new TrataModel();
		
		result = trataService.addTrata(trata);
		
		return result;
	}
	
	@GetMapping(value="/getAll")
	public ArrayList<TrataModel> getAllTramas(){
		ArrayList<TrataModel> result = new ArrayList<>();
		
		result = trataService.getAllTramas();
		
		return result;
	}
	
	@GetMapping(value="/get/{id}")
	public TrataModel getTrataById(@PathVariable(value="id") Integer id) {
		TrataModel result = new TrataModel();
		
		result = trataService.getTrataById(id);
		
		return result;
	}
	
	@GetMapping(value="/getByFilter")
	public ArrayList<TrataModel> getTramasByFilter(@RequestBody TrataModel filter){
		ArrayList<TrataModel> result = new ArrayList<>();
		
		result = trataService.getTramasByFilter(filter);
		
		return result;
	}
	
	@PutMapping(value="/update/{id}")
	public TrataModel updateTrata(@PathVariable(value="id") Integer id,@RequestBody TrataModel update) {
		TrataModel result = new TrataModel();
		
		result = trataService.updateTrata(id, update);
		
		return result;
	}
	
	@DeleteMapping(value="/delete/{id}")
	public Boolean deleteTrata(@PathVariable(value="id")Integer id) {
		Boolean result = false;
		
		result = trataService.deleteTrata(id);
		
		return result;
	}
}
