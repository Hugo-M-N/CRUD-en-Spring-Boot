package com.example.Biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Biblioteca.model.IdiomaModel;

@Repository
public interface IdiomaRepository extends JpaRepository<IdiomaModel, Integer> {

}
