package com.example.Biblioteca.service;

import com.example.Biblioteca.model.SocioModel;

public interface SocioService {

	public SocioModel addSocio(SocioModel socio);
	
	public SocioModel getSocioById(Integer id);
	
	public SocioModel updateSocio(Integer id, SocioModel socio);
	
	public Boolean deleteSocio(Integer id);
}
