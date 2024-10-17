package com.example.Biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Biblioteca.model.EscribeModel;

@Repository
public interface EscribeRepository extends JpaRepository<EscribeModel, Integer> {

}
