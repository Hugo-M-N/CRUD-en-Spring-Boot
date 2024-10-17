package com.example.Biblioteca.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="PRESTA")
public class PrestaModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPresta;
	
	private Integer idLibro;
	
	private Integer idEjemplar;
	
	private Integer idSocio;
	
	private Date fechaPrest;
	
	private Date fechaDev;

	public Integer getIdPresta() {
		return idPresta;
	}

	public void setIdPresta(Integer idPresta) {
		this.idPresta = idPresta;
	}

	public Integer getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(Integer idLibro) {
		this.idLibro = idLibro;
	}

	public Integer getIdEjemplar() {
		return idEjemplar;
	}

	public void setIdEjemplar(Integer idEjemplar) {
		this.idEjemplar = idEjemplar;
	}

	public Integer getIdSocio() {
		return idSocio;
	}

	public void setIdSocio(Integer idSocio) {
		this.idSocio = idSocio;
	}

	public Date getFechaPrest() {
		return fechaPrest;
	}

	public void setFechaPrest(Date fechaPrest) {
		this.fechaPrest = fechaPrest;
	}

	public Date getFechaDev() {
		return fechaDev;
	}

	public void setFechaDev(Date fechaDev) {
		this.fechaDev = fechaDev;
	}
}
