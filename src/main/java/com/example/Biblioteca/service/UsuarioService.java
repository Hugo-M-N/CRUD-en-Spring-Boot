package com.example.Biblioteca.service;

import java.util.ArrayList;

import com.example.Biblioteca.model.UsuarioModel;

public interface UsuarioService {

	public UsuarioModel addUsuario(UsuarioModel usuario);
	
	public ArrayList<UsuarioModel> getAllUsuarios();
	
	public UsuarioModel getUsuarioById(Integer id);
	
	public ArrayList<UsuarioModel> getUsuariosByFilter(UsuarioModel filter);
	
	public UsuarioModel updateUsuario(Integer id,UsuarioModel update);
	
	public Boolean deleteUsuario(Integer id);
}
