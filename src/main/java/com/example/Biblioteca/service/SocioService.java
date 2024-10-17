package com.example.Biblioteca.service;

import java.util.ArrayList;

import com.example.Biblioteca.model.SocioModel;

public interface SocioService {

	public SocioModel addSocio(SocioModel socio);
	
	public ArrayList<SocioModel> getAllSocios();
	
	public SocioModel getSocioById(Integer id);
	
	public ArrayList<SocioModel> getSociosByFilter(SocioModel filter);
	
	public SocioModel updateSocio(Integer id, SocioModel socio);
	
	public Boolean deleteSocio(Integer id);
}
