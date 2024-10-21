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

import com.example.Biblioteca.model.UsuarioModel;
import com.example.Biblioteca.service.UsuarioService;

@RestController
@RequestMapping(value="/usuario")
public class UsuarioController{

	@Autowired
	UsuarioService usuarioService;
	
	@PostMapping(value="/save")
	public UsuarioModel addUsuario(@RequestBody UsuarioModel usuario) {
		UsuarioModel result = new UsuarioModel();
		
		result = usuarioService.addUsuario(usuario);
		
		return result;
	}
	
	@GetMapping(value="/getAll")
	public ArrayList<UsuarioModel> getAllUsuarios(){
		ArrayList<UsuarioModel> result = new ArrayList<>();
		
		result = usuarioService.getAllUsuarios();
		
		return result;
	}
	
	@GetMapping(value="/get/{id}")
	public UsuarioModel getUsuarioById(@PathVariable(value="id") Integer id) {
		UsuarioModel result = new UsuarioModel();
		
		result = usuarioService.getUsuarioById(id);
		
		return result;
	}
	
	@GetMapping(value="/getByFilter")
	public ArrayList<UsuarioModel> getUsuariosByFilter(@RequestBody UsuarioModel filter){
		ArrayList<UsuarioModel> result = new ArrayList<>();
		
		result = usuarioService.getUsuariosByFilter(filter);
		
		return result;
	}
	
	@PutMapping(value="/update/{id}")
	public UsuarioModel updateUsuario(@PathVariable(value="id") Integer id, @RequestBody UsuarioModel update) {
		UsuarioModel result = new UsuarioModel();
		
		result = usuarioService.updateUsuario(id, update);
		
		return result;
		
	}
	
	@DeleteMapping(value="/delete/{id}")
	public Boolean deleteUsuario (@PathVariable(value="id") Integer id) {
		Boolean result = false;
		
		result = usuarioService.deleteUsuario(id);
		
		return result;
	}

}
