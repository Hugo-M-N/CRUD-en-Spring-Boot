package com.example.Biblioteca.service;

import java.util.ArrayList;

import com.example.Biblioteca.model.IdiomaModel;

public interface IdiomaService {

	public IdiomaModel addIdioma(IdiomaModel idioma);
	
	public ArrayList<IdiomaModel> getAllIdiomas();
	
	public IdiomaModel getIdiomaById(Integer id);
	
	public ArrayList<IdiomaModel> getIdiomasByFilter(IdiomaModel filter);
	
	public IdiomaModel updateIdioma(Integer id, IdiomaModel idioma);
	
	public Boolean deleteIdioma(Integer id);
}
