package com.example.Biblioteca.service;

import java.util.ArrayList;

import com.example.Biblioteca.model.EscribeModel;

public interface EscribeService {

	public EscribeModel addEscribe(EscribeModel escribe);
	
	public ArrayList<EscribeModel> getAllEscritos();
	
	public EscribeModel getEscribeById(Integer id);
	
	public ArrayList<EscribeModel> getEscritosByFilter(EscribeModel filter);
	
	public EscribeModel updateEscribe(Integer id, EscribeModel update);
	
	public Boolean deleteEscribe(Integer id);
}
