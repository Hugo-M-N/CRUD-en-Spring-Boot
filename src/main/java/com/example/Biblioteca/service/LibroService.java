package com.example.Biblioteca.service;

import java.util.ArrayList;

import com.example.Biblioteca.model.LibroModel;

public interface LibroService {

	public LibroModel guardaLibro(LibroModel libro);
	
	public ArrayList<LibroModel> getAllLibros();
	
	public LibroModel getLibroById(Integer id);
	
	public ArrayList<LibroModel> getLibrosByFilter(LibroModel filter);
	
	public LibroModel updateLibro(Integer id, LibroModel libro);
	
	public Boolean deleteLibro(Integer id);
	
}
