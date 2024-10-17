package com.example.Biblioteca.serviceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Biblioteca.model.PrestaModel;
import com.example.Biblioteca.repository.PrestaRepository;
import com.example.Biblioteca.service.PrestaService;

@Service
public class PrestaServiceImpl implements PrestaService {

	@Autowired
	PrestaRepository prestaRepo;
	
	@Override
	public PrestaModel addPresta(PrestaModel presta) {
		PrestaModel result = new PrestaModel();
		
		try {
			result = prestaRepo.save(presta);
		} catch (Exception e) {
			System.out.println("addPresta: "+ e.getMessage());
		}
		
		return result;
	}
	
	public ArrayList<PrestaModel> getAllPrestamos(){
		ArrayList<PrestaModel> result = new ArrayList<>();
		
		try {
			result = (ArrayList<PrestaModel>) prestaRepo.findAll();
		} catch (Exception e) {
			System.out.println("getAllPrestamos: "+ e.getMessage());
		}
		
		return result;
	}
	
	public PrestaModel getPrestaById(Integer id) {
		PrestaModel result = new PrestaModel();
		
		try {
			result = prestaRepo.findById(id).get();
		} catch (Exception e) {
			System.out.println("getPrestaById: "+ e.getMessage());
		}
		
		return result;
	}
	
	public ArrayList<PrestaModel> getPrestamosByFilter(PrestaModel filter){
		ArrayList<PrestaModel> result = new ArrayList<>();
		
		try {
			ArrayList<PrestaModel> prestamos = (ArrayList<PrestaModel>) prestaRepo.findAll();
			for(PrestaModel prestamo : prestamos) {
				if((prestamo.getIdPresta()==filter.getIdPresta()) || (prestamo.getIdLibro()==filter.getIdLibro()) || (prestamo.getIdEjemplar()==filter.getIdEjemplar()) ||
					(prestamo.getIdSocio()==filter.getIdSocio()) || (prestamo.getFechaPrest().equals(filter.getFechaPrest())) || (prestamo.getFechaDev().equals(filter.getFechaDev()))
						){
					result.add(prestamo);
				}
			}
		} catch (Exception e) {
			System.out.println("getPrestamosByFilter: "+ e.getMessage());
		}
		
		return result;
	}
	
	public PrestaModel updatePresta(Integer id, PrestaModel update) {
		PrestaModel result = new PrestaModel();
		
		try {
			PrestaModel presta = prestaRepo.findById(id).get();
			presta.setIdLibro(update.getIdLibro());
			presta.setIdEjemplar(update.getIdEjemplar());
			presta.setIdSocio(update.getIdSocio());
			presta.setFechaPrest(update.getFechaPrest());
			presta.setFechaDev(update.getFechaDev());
			result = presta;
		} catch (Exception e) {
			System.out.println("updatePresta: "+ e.getMessage());
		}
		
		return result;
	}
	
	public Boolean deletePresta(Integer id) {
		Boolean result =false;
		
		try {
			prestaRepo.deleteById(id);
			result = true;
		} catch (Exception e) {
			System.out.println("deletePresta: "+ e.getMessage());
		}
		
		return result;
	}

}
