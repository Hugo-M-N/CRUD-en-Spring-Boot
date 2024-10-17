package com.example.Biblioteca.service;

import com.example.Biblioteca.model.EscribeModel;

public interface EscribeService {

	public EscribeModel addEscribe(EscribeModel escribe);
	
	public EscribeModel getEscribeById(Integer id);
	
	public EscribeModel updateEscribe(Integer id, EscribeModel update);
	
	public Boolean deleteEscribe(Integer id);
}
