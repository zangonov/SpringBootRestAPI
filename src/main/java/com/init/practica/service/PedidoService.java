package com.init.practica.service;

import java.util.List;
import java.util.Optional;

import com.init.practica.entities.Pedido;



public interface PedidoService {
	
	public List<Pedido> findAll();
	
	public Optional<Pedido> findById(Long id);
	
	public Pedido create(Pedido pedido);
	
	public boolean update(Pedido pedido);
	
	public void deleteById(Long id);
}
