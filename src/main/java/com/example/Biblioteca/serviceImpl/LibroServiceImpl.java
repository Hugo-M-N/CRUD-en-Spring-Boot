package com.example.Biblioteca.serviceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Biblioteca.model.LibroModel;
import com.example.Biblioteca.repository.LibroRepository;
import com.example.Biblioteca.service.LibroService;

@Service
public class LibroServiceImpl implements LibroService{
	
	@Autowired
	LibroRepository libroRepo;


	@Override
	public LibroModel guardaLibro(LibroModel libro) {
		LibroModel result = new LibroModel();
		
		try {
			result = libroRepo.save(libro);
		} catch (Exception e) {
			System.out.println("guardaLibro: "+ e.getMessage());
			
		}
		return result;
		
	}
	
	public ArrayList<LibroModel> getAllLibros(){
		ArrayList<LibroModel> result = new ArrayList<>();
		
		try {
			result = (ArrayList<LibroModel>) libroRepo.findAll();
		} catch (Exception e) {
			System.out.println("getAllLibros: "+ e.getMessage());
		}
		
		return result;
	}
	
	public LibroModel getLibroById(Integer id) {
		LibroModel result = new LibroModel();
		
		try {
			result = libroRepo.findById(id).get();
		} catch (Exception e) {
			System.out.println("guardaLibro: "+ e.getMessage());
			
		}
		return result;
	}
	
	public ArrayList<LibroModel> getLibrosByFilter(LibroModel filter){
		ArrayList<LibroModel> result = new ArrayList<>();
		
		try {
			ArrayList<LibroModel> libros = (ArrayList<LibroModel>) libroRepo.findAll();
			for(LibroModel libro : libros) {
				if((libro.getIdLibro()==filter.getIdLibro()) || (libro.getTitulo().equals(filter.getTitulo())) ||
					(libro.getAnio()==filter.getAnio()) || (libro.getIdIdioma()==filter.getIdIdioma())
						) {
					result.add(libro);
				}
			}
		} catch (Exception e) {
			System.out.println("getLibrosByFilter:: "+ e.getMessage());
		}
		
		return result;
	}
	
	public LibroModel updateLibro(Integer id, LibroModel update) {
		LibroModel result = new LibroModel();
		try {
			LibroModel libro = libroRepo.findById(id).get();
	
			libro.setTitulo(update.getTitulo());
			libro.setAnio(update.getAnio());
			libro.setIdIdioma(update.getIdIdioma());
			
			result = libroRepo.save(libro);
			
		} catch (Exception e) {
			System.out.println("updateLibro: "+ e.getMessage());
		}
		
		return result;
	}
	
	public Boolean deleteLibro(Integer id) {
		Boolean result = false;
		
		try {
			libroRepo.deleteById(id);
			result = true;
		} catch (Exception e) {
			System.out.println("deleteLibro: "+ e.getMessage());
		}
		
		return result;
	}

}
