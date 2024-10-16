package com.example.Biblioteca.service;

import com.example.Biblioteca.model.IdiomaModel;

public interface IdiomaService {

	public IdiomaModel addIdioma(IdiomaModel idioma);
	
	public IdiomaModel getIdiomaById(Integer id);
	
	public IdiomaModel updateIdioma(Integer id, IdiomaModel idioma);
	
	public Boolean deleteIdioma(Integer id);
}
