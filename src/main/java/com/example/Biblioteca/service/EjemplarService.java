package com.example.Biblioteca.service;

import java.util.ArrayList;

import com.example.Biblioteca.model.EjemplarModel;

public interface EjemplarService {

	public EjemplarModel addEjemplar(EjemplarModel ejemplar);
	
	public ArrayList<EjemplarModel> getAllEjemplares();
	
	public EjemplarModel getEjemplarById(Integer id);
	
	public ArrayList<EjemplarModel> getEjemplaresByFilter(EjemplarModel filter);
	
	public EjemplarModel updateEjemplar(Integer id, EjemplarModel ejemplar);
	
	public Boolean deleteEjemplar(Integer id);
}
