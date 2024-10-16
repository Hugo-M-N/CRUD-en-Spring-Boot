package com.example.Biblioteca.service;

import com.example.Biblioteca.model.EjemplarModel;

public interface EjemplarService {

	public EjemplarModel addEjemplar(EjemplarModel ejemplar);
	
	public EjemplarModel getEjemplarById(Integer id);
	
	public EjemplarModel updateEjemplar(Integer id, EjemplarModel ejemplar);
	
	public Boolean deleteEjemplar(Integer id);
}
