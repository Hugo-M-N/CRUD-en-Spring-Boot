package com.example.Biblioteca.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Biblioteca.model.IdiomaModel;
import com.example.Biblioteca.service.IdiomaService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(value="/idioma")
public class IdiomaController {

	@Autowired
	IdiomaService idiomaService;
	
	@PostMapping("/save")
	public IdiomaModel addIdioma(@RequestBody IdiomaModel idioma) {
		IdiomaModel result = new IdiomaModel();

		result = idiomaService.addIdioma(idioma);
		
		return result;
	}
	
	@GetMapping(value="/getAll")
	public ArrayList<IdiomaModel> getAllIdiomas(){
		ArrayList<IdiomaModel> result = new ArrayList<>();
		
		result = idiomaService.getAllIdiomas();
		
		return result;
	}
	
	@GetMapping("/get/{id}")
	public IdiomaModel getIdiomaById(@PathVariable(value = "id") Integer id) {
		IdiomaModel result = new IdiomaModel();
		
		result = idiomaService.getIdiomaById(id);
		
		return result;
	}
	
	@GetMapping(value="/getByFilter")
	public ArrayList<IdiomaModel> getIdiomasByFilter(@RequestBody IdiomaModel filter){
		ArrayList<IdiomaModel> result = new ArrayList<>();
		
		result = idiomaService.getIdiomasByFilter(filter);
		
		return result;
	}
	
	@PutMapping(value="/update/{id}")
	public IdiomaModel updateIdioma(@PathVariable(value="id") Integer id, @RequestBody IdiomaModel update) {
		IdiomaModel result = new IdiomaModel();
		
		result = idiomaService.updateIdioma(id, update);
		
		return result;
		
	}
	
	@DeleteMapping(value="/delete/{id}")
	public Boolean deleteIdioma (@PathVariable(value="id") Integer id) {
		Boolean result = false;
		
		result = idiomaService.deleteIdioma(id);
		
		return result;
	}
	
}
