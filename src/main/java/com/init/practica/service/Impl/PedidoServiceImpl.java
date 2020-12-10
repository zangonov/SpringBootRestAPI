package com.init.practica.service.Impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.init.practica.daos.ArticulosPedidosDAO;
import com.init.practica.daos.PedidosDAO;
import com.init.practica.entities.ArticulosPedido;
import com.init.practica.entities.Pedido;
import com.init.practica.service.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService{

	private static final Logger logger = LoggerFactory.getLogger(PedidoServiceImpl.class);
	
	@Autowired
	private PedidosDAO pedidosDAO; 
	
	@Autowired
	private ArticulosPedidosDAO articulosPedidosDAO; 
	
	
	@Override
	@Transactional
	public List<Pedido> findAll() {
		logger.debug("PedidoServiceImpl.findAll ");
		return pedidosDAO.findAll();
	}

	@Override
	@Transactional
	public Optional<Pedido> findById(Long id) {
		logger.debug("PedidoServiceImpl.findById " + id);
		return  pedidosDAO.findById(id);
	}
	
	@Override
	@Transactional
	public Pedido create(Pedido pedido) {
		logger.debug("PedidoServiceImpl.create " + pedido.toString());
	
		Pedido nuevoPedido = pedidosDAO.save(pedido);
		
		if(pedido.getArticulosPedido()!=null){
			for (ArticulosPedido entity : pedido.getArticulosPedido()) {
				entity.setPedido(nuevoPedido);
				articulosPedidosDAO.save(entity);
			}
		}
		return nuevoPedido;
	}

	@Override
	@Transactional
	public boolean update(Pedido pedido) {
		logger.debug("PedidoServiceImpl.update " + pedido.toString());
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
	@Transactional
	public void deleteById(Long id) {
		logger.debug("PedidoServiceImpl.deleteById "+ id);
		
		Optional<Pedido> optionalPedido = pedidosDAO.findById(id);
		
		if(optionalPedido.get().getArticulosPedido()!=null){
			for (ArticulosPedido entity : optionalPedido.get().getArticulosPedido()) {
				articulosPedidosDAO.deleteById(entity.getId());
			}
		}
		pedidosDAO.deleteById(id);		
	}

}
