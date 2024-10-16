package com.example.Biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Biblioteca.model.EjemplarModel;

@Repository
public interface EjemplarRepository extends JpaRepository<EjemplarModel, Integer> {

}
