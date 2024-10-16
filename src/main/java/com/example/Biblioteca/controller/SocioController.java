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

import com.example.Biblioteca.model.SocioModel;
import com.example.Biblioteca.service.SocioService;

@RestController
@RequestMapping(value="/socio")
public class SocioController {
	
	@Autowired
	SocioService socioService;
	
	@PostMapping(value="/save")
	public SocioModel addSocio(@RequestBody SocioModel socio) {
		SocioModel result = new SocioModel();
		
		result = socioService.addSocio(socio);
		
		return result;
	}
	
	@GetMapping(value="/get/{id}")
	public SocioModel getSocioById(@PathVariable(value="id") Integer id) {
		SocioModel result = new SocioModel();
		
		result = socioService.getSocioById(id);
		
		return result;
	}
	
	@PutMapping(value="/update/{id}")
	public SocioModel updateSocio(@PathVariable(value="id") Integer id, @RequestBody SocioModel update) {
		SocioModel result = new SocioModel();
		
		result = socioService.updateSocio(id, update);
		
		return result;
		
	}
	
	@DeleteMapping(value="/delete/{id}")
	public Boolean deleteSocio (@PathVariable(value="id") Integer id) {
		Boolean result = false;
		
		result = socioService.deleteSocio(id);
		
		return result;
	}
}
