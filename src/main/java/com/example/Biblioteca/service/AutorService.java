package com.example.Biblioteca.service;

import com.example.Biblioteca.model.AutorModel;

public interface AutorService {

	public AutorModel addAutor(AutorModel autor);
	
	public AutorModel getAutorById(Integer id);
	
	public AutorModel updateAutor(Integer id, AutorModel autor);
	
	public Boolean deleteAutor(Integer id);
	
}
