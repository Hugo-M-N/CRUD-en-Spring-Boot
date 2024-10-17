package com.example.Biblioteca.service;

import java.util.ArrayList;

import com.example.Biblioteca.model.AutorModel;

public interface AutorService {

	public AutorModel addAutor(AutorModel autor);
	
	public ArrayList<AutorModel> getAllAutores();
	
	public AutorModel getAutorById(Integer id);
	
	public ArrayList<AutorModel> getAutoresByFilter(AutorModel filter);
	
	public AutorModel updateAutor(Integer id, AutorModel autor);
	
	public Boolean deleteAutor(Integer id);
	
}
