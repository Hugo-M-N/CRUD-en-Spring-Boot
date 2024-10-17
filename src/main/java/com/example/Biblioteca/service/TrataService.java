package com.example.Biblioteca.service;

import com.example.Biblioteca.model.TrataModel;

public interface TrataService {
	
	public TrataModel addTrata(TrataModel trata);
	
	public TrataModel getTrataById(Integer id);
	
	public TrataModel updateTrata(Integer id, TrataModel update);
	
	public Boolean deleteTrata(Integer id);

}
