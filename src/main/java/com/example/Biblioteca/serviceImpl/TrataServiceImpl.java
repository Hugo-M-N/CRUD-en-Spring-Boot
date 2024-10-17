package com.example.Biblioteca.serviceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Biblioteca.model.TrataModel;
import com.example.Biblioteca.repository.TrataRepository;
import com.example.Biblioteca.service.TrataService;

@Service
public class TrataServiceImpl implements TrataService{

	@Autowired
	TrataRepository trataRepo;
	
	@Override
	public TrataModel addTrata(TrataModel trata) {
		TrataModel result = new TrataModel();
		
		try {
			result = trataRepo.save(trata);
		} catch (Exception e) {
			System.out.println("addTrata: "+ e.getMessage());
		}
		
		return result;
	}
	
	public ArrayList<TrataModel> getAllTramas(){
		ArrayList<TrataModel> result = new ArrayList<>();
		
		try {
			result = (ArrayList<TrataModel>) trataRepo.findAll();
		} catch (Exception e) {
			System.out.println("getAllTramas: "+ e.getMessage());
		}
		
		return result;
	}
	
	public TrataModel getTrataById(Integer id) {
		TrataModel result = new TrataModel();
		
		try {
			result = trataRepo.findById(id).get();
		} catch (Exception e) {
			System.out.println("getTrataById: "+ e.getMessage());
		}
		
		return result;
	}
	
	public ArrayList<TrataModel> getTramasByFilter(TrataModel filter){
		ArrayList<TrataModel> result = new ArrayList<>();
		
		try {
			ArrayList<TrataModel> tramas = (ArrayList<TrataModel>) trataRepo.findAll();
			for(TrataModel trata : tramas) {
				if((trata.getIdTrata()==filter.getIdTrata()) || (trata.getIdTema()==filter.getIdTema()) || (trata.getIdLibro()==filter.getIdLibro())) {
					result.add(trata);
				}
			}
		} catch (Exception e) {
			System.out.println("getTramasByFilter: "+ e.getMessage());
		}
		
		return result;
	}
	
	public TrataModel updateTrata(Integer id, TrataModel update) {
		TrataModel result = new TrataModel();
		
		try {
			TrataModel trata = trataRepo.findById(id).get();
			trata.setIdLibro(update.getIdLibro());
			trata.setIdTema(update.getIdTema());
			result = trata;
		} catch (Exception e) {
			System.out.println("updateTrata: "+ e.getMessage());
		}
		
		return result;
	}
	
	public Boolean deleteTrata(Integer id) {
		Boolean result = false;
		
		try {
			trataRepo.deleteById(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return result;
	}

}
