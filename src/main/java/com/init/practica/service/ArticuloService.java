package com.init.practica.service;

import java.util.List;
import java.util.Optional;

import com.init.practica.entities.Articulo;

public interface ArticuloService {
	
	public List<Articulo> findAll();
	
	public Optional<Articulo> findById(long id);
	
	public List<Articulo> findAllByCatalogo(long CatalogoId);
	
	public List<Articulo> findAllByArticuloIdPedido(long articuloId);
	
	public Articulo create(Articulo articulo);
	
	public boolean update(Articulo articulo);
	
	public void deleteById(Long id);

}
