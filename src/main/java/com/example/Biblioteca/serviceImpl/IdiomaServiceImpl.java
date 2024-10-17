package com.example.Biblioteca.serviceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Biblioteca.model.IdiomaModel;
import com.example.Biblioteca.repository.IdiomaRepository;
import com.example.Biblioteca.service.IdiomaService;

@Service
public class IdiomaServiceImpl implements IdiomaService{

	@Autowired
	 IdiomaRepository idiomaRepo;
	
	@Override
	public IdiomaModel addIdioma(IdiomaModel idioma) {
		IdiomaModel result = new IdiomaModel();
		
		try {
			result = idiomaRepo.save(idioma);
		} catch (Exception e) {
			System.out.println("addIdioma: "+ e.getMessage());
		}
		return result;
	}
	
	public ArrayList<IdiomaModel> getAllIdiomas(){
		ArrayList<IdiomaModel> result = new ArrayList<>();
		
		try {
			result = (ArrayList<IdiomaModel>) idiomaRepo.findAll();
			
		} catch (Exception e) {
			System.out.println("getAllIdiomas: "+ e.getMessage());
		}
		
		return result;
	}
	
	public IdiomaModel getIdiomaById(Integer id) {
		IdiomaModel result = new IdiomaModel();
		
		try {
			result = idiomaRepo.findById(id).get();
		} catch (Exception e) {
			System.out.println("getIdiomaById: "+ e.getMessage());
			
		}
		return result;
	}
	
	public ArrayList<IdiomaModel> getIdiomasByFilter(IdiomaModel filter){
		ArrayList<IdiomaModel> result = new ArrayList<>();
		
		try {
			ArrayList<IdiomaModel> idiomas = (ArrayList<IdiomaModel>) idiomaRepo.findAll();
			for(IdiomaModel idioma : idiomas) {
				if((idioma.getIdIdioma()==filter.getIdIdioma()) || (idioma.getDescripcion().equals(filter.getDescripcion()))) {
					result.add(idioma);
				}
			}
		} catch (Exception e) {
			System.out.println("getIdiomasByFilter: "+ e.getMessage());
		}
		
		return result;
	}
	
	public IdiomaModel updateIdioma (Integer id, IdiomaModel update) {
		IdiomaModel result = new IdiomaModel();
		
		try {
			IdiomaModel idioma = idiomaRepo.findById(id).get();
			idioma.setDescripcion(update.getDescripcion());
			result = idioma;
		} catch (Exception e) {
			System.out.println("updateIdioma: "+e.getMessage());
		}
		
		return result;
	}
	
	public Boolean deleteIdioma(Integer id) {
		Boolean result = false;
		
		try {
			idiomaRepo.deleteById(id);
			result = true;
		} catch (Exception e) {
			System.out.println("deleteIdioma: "+ e.getMessage());
		}
		
		return result;
	}
	
}
