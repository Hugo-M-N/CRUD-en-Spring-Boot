package com.example.Biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Biblioteca.model.LibroModel;

@Repository
public interface LibroRepository extends JpaRepository<LibroModel, Integer>{

}
