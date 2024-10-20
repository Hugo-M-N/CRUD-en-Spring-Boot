package com.example.Biblioteca.serviceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Biblioteca.model.EjemplarModel;
import com.example.Biblioteca.repository.EjemplarRepository;
import com.example.Biblioteca.service.EjemplarService;

@Service
public class EjemplarServiceImpl implements EjemplarService {
	
	@Autowired
	EjemplarRepository ejemplarRepo;
	
	@Override
	public EjemplarModel addEjemplar(EjemplarModel ejemplar) {
		EjemplarModel result = new EjemplarModel();
		
		try {
			result = ejemplarRepo.save(ejemplar);
		} catch (Exception e) {
			System.out.println("addEjemplar: "+ e.getMessage());
		}
		
		return result;
	}
	
	public ArrayList<EjemplarModel> getAllEjemplares(){
		ArrayList<EjemplarModel> result = new ArrayList<>();
		
		try {
			result = (ArrayList<EjemplarModel>) ejemplarRepo.findAll();
		} catch (Exception e) {
			System.out.println("getAllEjemplares: "+ e.getMessage());
		}
		
		return result;
	}
	
	public EjemplarModel getEjemplarById(Integer id) {
		EjemplarModel result = new EjemplarModel();
		
		try {
			result = ejemplarRepo.findById(id).get();
		} catch (Exception e) {
			System.out.println("getEjemplaarById: "+ e.getMessage());
		}
		
		return result;
	}
	
	public ArrayList<EjemplarModel> getEjemplaresByFilter(EjemplarModel filter){
		ArrayList<EjemplarModel> result = new ArrayList<>();
		
		try {
			ArrayList<EjemplarModel> ejemplares = (ArrayList<EjemplarModel>) ejemplarRepo.findAll();
			for(EjemplarModel ejemplar : ejemplares) {
				if((ejemplar.getIdEjemplar()==filter.getIdEjemplar()) || (ejemplar.getIdLibro()==filter.getIdLibro())) {
					result.add(ejemplar);
				}
			}
		} catch (Exception e) {
			System.out.println("GetEjemplaresByFilter: "+ e.getMessage());
		}
		
		return result;
	}
	
	public EjemplarModel updateEjemplar(Integer id, EjemplarModel update) {
		EjemplarModel result = new EjemplarModel();
		
		try {
			EjemplarModel ejemplar = ejemplarRepo.findById(id).get();
			ejemplar.setIdLibro(update.getIdLibro());
			result = ejemplar;
		} catch (Exception e) {
			System.out.println("updateEjemplar: "+ e.getMessage());
		}
		
		return result;
	}
	
	public Boolean deleteEjemplar(Integer id) {
		Boolean result = false;
		
		try {
			ejemplarRepo.deleteById(id);
			result = true;
		} catch (Exception e) {
			System.out.println("deleteEjemplar: "+ e.getMessage());
		}
		
		return result;
	}

}
