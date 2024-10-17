package com.example.Biblioteca.service;

import java.util.ArrayList;

import com.example.Biblioteca.model.TemaModel;

public interface TemaService {
	
	public TemaModel addTema(TemaModel tema);
	
	public ArrayList<TemaModel> getAllTemas();
	
	public TemaModel getTemaById(Integer id);
	
	public ArrayList<TemaModel> getTemasByFilter(TemaModel filter);
	
	public TemaModel updateTema(Integer id, TemaModel tema);
	
	public Boolean deleteTema(Integer id);
}
