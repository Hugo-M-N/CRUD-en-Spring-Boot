package com.example.Biblioteca.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="IDIOMA")
public class IdiomaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idIdioma;
	
	private String descripcion;

	public Integer getIdIdioma() {
		return idIdioma;
	}

	public void setIdIdioma(Integer idIdioma) {
		this.idIdioma = idIdioma;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
