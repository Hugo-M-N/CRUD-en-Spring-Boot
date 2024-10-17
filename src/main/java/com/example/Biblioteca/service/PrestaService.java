package com.example.Biblioteca.service;

import com.example.Biblioteca.model.PrestaModel;

public interface PrestaService {

	public PrestaModel addPresta(PrestaModel presta);
	
	public PrestaModel getPrestaById(Integer id);
	
	public PrestaModel updatePresta(Integer id, PrestaModel update);
	
	public Boolean deletePresta(Integer id);
}
