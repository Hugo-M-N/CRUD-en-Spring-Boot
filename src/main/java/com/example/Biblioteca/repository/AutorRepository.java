package com.example.Biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Biblioteca.model.AutorModel;

@Repository
public interface AutorRepository extends JpaRepository<AutorModel, Integer>{

}
