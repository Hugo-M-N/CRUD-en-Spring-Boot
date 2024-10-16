package com.example.Biblioteca.service;

import com.example.Biblioteca.model.LibroModel;

public interface LibroService {

	public LibroModel guardaLibro(LibroModel libro);
	
	public LibroModel getLibroById(Integer id);
	
	public LibroModel updateLibro(Integer id, LibroModel libro);
	
	public Boolean deleteLibro(Integer id);
	
}
