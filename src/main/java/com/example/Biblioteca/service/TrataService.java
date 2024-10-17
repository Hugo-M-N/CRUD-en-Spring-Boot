package com.example.Biblioteca.service;

import java.util.ArrayList;

import com.example.Biblioteca.model.TrataModel;

public interface TrataService {
	
	public TrataModel addTrata(TrataModel trata);
	
	public ArrayList<TrataModel> getAllTramas();
	
	public TrataModel getTrataById(Integer id);
	
	public ArrayList<TrataModel> getTramasByFilter(TrataModel filter);
	
	public TrataModel updateTrata(Integer id, TrataModel update);
	
	public Boolean deleteTrata(Integer id);

}
