package com.example.Biblioteca.service;

import java.util.ArrayList;

import com.example.Biblioteca.model.PrestaModel;

public interface PrestaService {

	public PrestaModel addPresta(PrestaModel presta);
	
	public ArrayList<PrestaModel> getAllPrestamos();
	
	public PrestaModel getPrestaById(Integer id);
	
	public ArrayList<PrestaModel> getPrestamosByFilter(PrestaModel filter);
	
	public PrestaModel updatePresta(Integer id, PrestaModel update);
	
	public Boolean deletePresta(Integer id);
}
