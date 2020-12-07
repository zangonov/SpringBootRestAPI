package com.init.practica.service;

import java.util.List;
import java.util.Optional;

import com.init.practica.entities.Catalogo;


public interface CatalogoService {
	
	public List<Catalogo> findAll();
	
	public Optional<Catalogo> findById(Long id);
	
	public Catalogo create(Catalogo catalogo);
	
	public boolean update(Catalogo catalogo);
	
	public void deleteById(Long id);
}
