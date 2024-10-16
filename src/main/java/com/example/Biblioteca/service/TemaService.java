package com.example.Biblioteca.service;

import com.example.Biblioteca.model.LibroModel;
import com.example.Biblioteca.model.TemaModel;

public interface TemaService {
	
	public TemaModel addTema(TemaModel tema);
	
	public TemaModel getTemaById(Integer id);
	
	public TemaModel updateTema(Integer id, TemaModel tema);
	
	public Boolean deleteTema(Integer id);
}
