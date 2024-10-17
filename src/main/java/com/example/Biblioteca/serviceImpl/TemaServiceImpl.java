package com.example.Biblioteca.serviceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Biblioteca.model.TemaModel;
import com.example.Biblioteca.repository.TemaRepository;
import com.example.Biblioteca.service.TemaService;

@Service
public class TemaServiceImpl implements TemaService {

	@Autowired
	TemaRepository temaRepo;
	
	@Override
	public TemaModel addTema(TemaModel tema) {
		TemaModel result = new TemaModel();
		
		try {
			result = temaRepo.save(tema);
		} catch (Exception e) {
			System.out.println("addTema: "+ e.getMessage());
		}
		
		return result;
	}
	
	public ArrayList<TemaModel> getAllTemas(){
		ArrayList<TemaModel> result = new ArrayList<>();
		
		try {
			result = (ArrayList<TemaModel>) temaRepo.findAll();
		} catch (Exception e) {
			System.out.println("getAllTemas: "+ e.getMessage());
		}
		
		return result;
	}
	
	public TemaModel getTemaById(Integer id) {
		TemaModel result = new TemaModel();
		
		try {
			result = temaRepo.findById(id).get();
		} catch (Exception e) {
			System.out.println("getTemaById: "+ e.getMessage());
		}
		
		return result;
	}
	
	public ArrayList<TemaModel> getTemasByFilter(TemaModel filter){
		ArrayList<TemaModel> result = new ArrayList<>();
		
		try {
			ArrayList<TemaModel> temas = (ArrayList<TemaModel>) temaRepo.findAll();
			for(TemaModel tema : temas) {
				if((tema.getIdTema()==filter.getIdTema()) || (tema.getDescripcion().equals(filter.getDescripcion()))) {
					result.add(tema);
				}
			}
		} catch (Exception e) {
			System.out.println("getTemasByFilter: "+ e.getMessage());
		}
		
		return result;
	}
	
	public TemaModel updateTema(Integer id, TemaModel update) {
		TemaModel result = new TemaModel();
		
		try {
			TemaModel tema = temaRepo.findById(id).get();
			tema.setDescripcion(update.getDescripcion());
			result = tema;
		} catch (Exception e) {
			System.out.println("updateTema: "+ e.getMessage());
		}
		
		return result;
	}
	
	public Boolean deleteTema(Integer id) {
		Boolean result = false;
		
		try {
			temaRepo.deleteById(id);
			result = true;
		} catch (Exception e) {
			System.out.println("deleteTema: "+ e.getMessage());
		}
		
		return result;
	}
}
