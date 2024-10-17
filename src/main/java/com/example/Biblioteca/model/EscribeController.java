package com.example.Biblioteca.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Biblioteca.service.EscribeService;

@RestController
@RequestMapping(value="/escribe")
public class EscribeController {

	@Autowired
	EscribeService escribeService;
	
	@PostMapping(value="/save")
	public EscribeModel addEscribe(@RequestBody EscribeModel escribe) {
		EscribeModel result = new EscribeModel();
		
		result = escribeService.addEscribe(escribe);
		
		return result;
	}
	
	@GetMapping(value="/get/{id}")
	public EscribeModel getEscribeById(@PathVariable(value="id") Integer id) {
		EscribeModel result = new EscribeModel();
		
		result = escribeService.getEscribeById(id);
		
		return result;
	}
	
	@PutMapping(value="/update/{id}")
	public EscribeModel updateEscribe(@PathVariable(value="id")Integer id, @RequestBody EscribeModel update) {
		EscribeModel result = new EscribeModel();
		
		result = escribeService.updateEscribe(id, update);
		
		return result;
	}
	
	@DeleteMapping(value="/delete/{id}")
	public Boolean deleteEscribe(@PathVariable(value="id")Integer id) {
		Boolean result = false;
		
		result = escribeService.deleteEscribe(id);
		
		return result;
	}
}
