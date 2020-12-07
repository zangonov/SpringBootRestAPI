package com.init.practica.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.init.practica.daos.PedidosDAO;
import com.init.practica.entities.Pedido;
import com.init.practica.service.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService{

	
	@Autowired
	private PedidosDAO pedidosDAO; 
	
	
	@Override
	public List<Pedido> findAll() {
		return pedidosDAO.findAll();
	}

	@Override
	public Optional<Pedido> findById(Long id) {
		return  pedidosDAO.findById(id);
	}

	@Override
	public Pedido create(Pedido pedido) {
		
		return pedidosDAO.save(pedido);
	}

	@Override
	public boolean update(Pedido pedido) {
		
		Optional<Pedido> optionalPedido = pedidosDAO.findById(pedido.getId());
		
		if (optionalPedido.isPresent()) {
			
			Pedido updatePedido = optionalPedido.get();
			updatePedido.setNombre(pedido.getNombre());
			pedidosDAO.save(updatePedido);
			return true;	
		}
		else
		{
			return false; 
		}
	}

	@Override
	public void deleteById(Long id) {
		pedidosDAO.deleteById(id);		
	}

}
