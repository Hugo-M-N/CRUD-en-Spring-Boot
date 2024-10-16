package com.example.Biblioteca.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="EJEMPLAR")
public class EjemplarModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idEjemplar;
	
	private Integer idLibro;

	public Integer getIdEjemplar() {
		return idEjemplar;
	}

	public void setIdEjemplar(Integer idEjemplar) {
		this.idEjemplar = idEjemplar;
	}

	public Integer getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(Integer idLibro) {
		this.idLibro = idLibro;
	}
}
