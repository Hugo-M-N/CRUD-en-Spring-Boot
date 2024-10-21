package com.example.Biblioteca.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.Biblioteca.model.UsuarioModel;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        
    	UsuarioModel filter = new UsuarioModel();
    	filter.setEmail(email);
        ArrayList<UsuarioModel> usuarios = usuarioService.getUsuariosByFilter(filter);
        User user = null;
        for(UsuarioModel usuario : usuarios) {
        	
        	user = new org.springframework.security.core.userdetails.User(usuario.getEmail(), usuario.getPassword(), new ArrayList<>());        }
		return user;

    }
}

