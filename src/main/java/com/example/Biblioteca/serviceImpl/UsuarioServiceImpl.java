package com.example.Biblioteca.serviceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Biblioteca.model.UsuarioModel;
import com.example.Biblioteca.repository.UsuarioRepository;
import com.example.Biblioteca.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	UsuarioRepository usuarioRepo;
	
	@Override
	public UsuarioModel addUsuario(UsuarioModel usuario) {
		UsuarioModel result = new UsuarioModel();
		
		try {
			result = usuarioRepo.save(usuario);
		} catch (Exception e) {
			System.out.println("addUsuario: "+ e.getMessage());
		}
		
		return result;
	}
	
	public ArrayList<UsuarioModel> getAllUsuarios(){
		ArrayList<UsuarioModel> result = new ArrayList<>();
		try {
			result = (ArrayList<UsuarioModel>) usuarioRepo.findAll();
		} catch (Exception e) {
			System.out.println("getAllUsuarios: "+ e.getMessage());
		}
		
		return result;
	}
	
	public UsuarioModel getUsuarioById(Integer id) {
		UsuarioModel result = new UsuarioModel();
		
		try {
			result = usuarioRepo.findById(id).get();
		} catch (Exception e) {
			System.out.println("getUsuarioById: "+ e.getMessage());
		}
		
		return result;
	}
	
	public ArrayList<UsuarioModel> getUsuariosByFilter(UsuarioModel filter){
		ArrayList<UsuarioModel> result = new ArrayList<>();
		
		try {
			ArrayList<UsuarioModel> usuarios = (ArrayList<UsuarioModel>) usuarioRepo.findAll();
			for(UsuarioModel usuario : usuarios) {
				if((usuario.getIdUsuario()==filter.getIdUsuario()) || (usuario.getNombre().equals(usuario.getNombre())) || (usuario.getEmail().equals(filter.getEmail())) ||
					(usuario.getPassword().equals(filter.getPassword())) || (usuario.getConfirmado()==filter.getConfirmado()) || (usuario.getToken().equals(filter.getToken())) ||
					(usuario.getAdmin()==filter.getAdmin()) ) {
					result.add(usuario);
				}
			}
		} catch (Exception e) {
			System.out.println("getUsuariosByFilter: "+ e.getMessage());
		}
		
		return result;
	}
	
	public UsuarioModel updateUsuario(Integer id, UsuarioModel update) {
		UsuarioModel result = new UsuarioModel();
		
		try {
			UsuarioModel usuario = usuarioRepo.findById(id).get();
			usuario.setNombre(update.getNombre());
			usuario.setEmail(update.getEmail());
			usuario.setPassword(update.getPassword());
			usuario.setConfirmado(update.getConfirmado());
			usuario.setToken(update.getToken());
			usuario.setAdmin(update.getAdmin());
			result = usuario;
			
		} catch (Exception e) {
			System.out.println("updateUsuario: "+ e.getMessage());
		}
		
		return result;
	}
	
	public Boolean deleteUsuario(Integer id) {
		Boolean result = false;
		
		try {
			usuarioRepo.deleteById(id);
			result = true;
		} catch (Exception e) {
			System.out.println("deleteUsuario: "+ e.getMessage());
		}
		
		return result;
	}

}
