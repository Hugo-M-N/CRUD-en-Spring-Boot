package com.example.Biblioteca.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Biblioteca.model.AutorModel;
import com.example.Biblioteca.repository.AutorRepository;
import com.example.Biblioteca.service.AutorService;

@Service
public class AutorServiceImpl implements AutorService {

	@Autowired
	AutorRepository autorRepo;
	
	@Override
	public AutorModel addAutor(AutorModel autor) {
		AutorModel result = new AutorModel();
		
		try {
			result = autorRepo.save(autor);
		} catch (Exception e) {
			System.out.println("addAutor: "+ e.getMessage());
		}
		
		return result;
	}
	
	public AutorModel getAutorById(Integer id) {
		AutorModel result = new AutorModel();
		
		try {
			result = autorRepo.findById(id).get();
		} catch (Exception e) {
			System.out.println("getAutorById: "+ e.getMessage());
		}
		
		return result;
	}
	
	public AutorModel updateAutor(Integer id, AutorModel update) {
		AutorModel result = new AutorModel();
		
		try {
			AutorModel autor = autorRepo.findById(id).get();
			autor.setNombre(update.getNombre());
			result = autor;
		} catch (Exception e) {
			System.out.println("updateautor: "+e.getMessage());
		}
		
		return result;
	}
	
	public Boolean deleteAutor(Integer id) {
		Boolean result = false;
		
		try {
			autorRepo.deleteById(id);
			result = true;
		} catch (Exception e) {
			System.out.println("deleteAutor: "+ e.getMessage());
		}
		
		return result;
	}


}
