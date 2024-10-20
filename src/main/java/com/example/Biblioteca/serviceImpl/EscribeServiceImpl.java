package com.example.Biblioteca.serviceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Biblioteca.model.EscribeModel;
import com.example.Biblioteca.repository.EscribeRepository;
import com.example.Biblioteca.service.EscribeService;

@Service
public class EscribeServiceImpl implements EscribeService {
	
	@Autowired
	EscribeRepository escribeRepo;
	
	@Override
	public EscribeModel addEscribe(EscribeModel escribe) {
		EscribeModel result = new EscribeModel();
		
		try {
			result = escribeRepo.save(escribe);
		} catch (Exception e) {
			System.out.println("addEscribe: "+ e.getMessage());
		}
		
		return result;
	}
	
	public ArrayList<EscribeModel> getAllEscritos(){
		ArrayList<EscribeModel> result = new ArrayList<>();
		
		try {
			result = (ArrayList<EscribeModel>) escribeRepo.findAll();
		} catch (Exception e) {
			System.out.println("getAllEscritos: "+ e.getMessage());
		}
		
		return result;
	}
	
	public EscribeModel getEscribeById(Integer id) {
		EscribeModel result = new EscribeModel();
		
		try {
			result = escribeRepo.findById(id).get();
		} catch (Exception e) {
			System.out.println("getEscribeById;: "+ e.getMessage());
		}
		
		return result;
	}
	
	public ArrayList<EscribeModel> getEscritosByFilter(EscribeModel filter){
		ArrayList<EscribeModel> result = new ArrayList<>();
		
		try {
			ArrayList<EscribeModel> escritos = (ArrayList<EscribeModel>) escribeRepo.findAll();
			for(EscribeModel escrito : escritos) {
				if((escrito.getIdAutor()==filter.getIdAutor()) || (escrito.getIdEscribe()==filter.getIdEscribe()) || (escrito.getIdLibro()==filter.getIdLibro())) {
					result.add(escrito);
				}
			}
		} catch (Exception e) {
			System.out.println("getEscritosyFilter: "+ e.getMessage());
		}
		
		return result;
	}
	
	public EscribeModel updateEscribe(Integer id, EscribeModel update) {
		EscribeModel result = new EscribeModel();
		
		try {
			EscribeModel escribe = escribeRepo.findById(id).get();
			escribe.setIdAutor(update.getIdAutor());
			escribe.setIdLibro(update.getIdLibro());
			result = escribe;
		} catch (Exception e) {
			System.out.println("updateEscribe: "+ e.getMessage());
		}
		
		return result;
	}
	
	public Boolean deleteEscribe(Integer id) {
		Boolean result = false;
		
		try {
			escribeRepo.deleteById(id);
			result = true;
		} catch (Exception e) {
			System.out.println("deleteEscribe: "+ e.getMessage());
		}
		
		return result;
	}

}
