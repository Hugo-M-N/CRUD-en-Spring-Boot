package com.example.Biblioteca.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Biblioteca.model.SocioModel;
import com.example.Biblioteca.repository.SocioRepository;
import com.example.Biblioteca.service.SocioService;

@Service
public class SocioServiceImpl implements SocioService{
	
	@Autowired
	SocioRepository SocioRepo;
	
	@Override
	public SocioModel addSocio(SocioModel socio) {
		SocioModel result = new SocioModel();
		
		try {
			result = SocioRepo.save(socio);
		} catch (Exception e) {
			System.out.println("addSocio: "+ e.getMessage());
		}
		
		return result;
	}
	
	public SocioModel getSocioById(Integer id) {
		SocioModel result = new SocioModel();
		
		try {
			result = SocioRepo.findById(id).get();
		} catch (Exception e) {
			System.out.println("getSocioById: "+ e.getMessage());
		}
		
		return result;
	}
	
	public SocioModel updateSocio(Integer id, SocioModel update) {
		SocioModel result = new SocioModel();
		
		try {
			SocioModel socio = SocioRepo.findById(id).get();
			socio.setNombre(update.getNombre());
			socio.setDomicilio(update.getDomicilio());
			socio.setTelefono(update.getTelefono());
			result = socio;
		} catch (Exception e) {
			System.out.println("updateSocio: "+ e.getMessage());
		}
		
		return result;
	}
	
	public Boolean deleteSocio(Integer id) {
		Boolean result = false;
		
		try {
			SocioRepo.deleteById(id);
			result = true;
		} catch (Exception e) {
			System.out.println("deleteSocio: "+ e.getMessage());
		}
		
		return result;
	}

}
