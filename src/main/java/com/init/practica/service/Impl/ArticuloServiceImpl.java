package com.init.practica.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.init.practica.daos.ArticulosDAO;
import com.init.practica.entities.Articulo;
import com.init.practica.service.ArticuloService;

@Service
public class ArticuloServiceImpl  implements ArticuloService{

	
	@Autowired
	private ArticulosDAO articulosDAO;
	
	@Override
	@Transactional(readOnly = true)
	public List<Articulo> findAllByCatalogo(long id) {
		return  articulosDAO.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Articulo> findAllByPedido(long id) {
		return  articulosDAO.findAllByPedido(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Articulo> findAll() {
		return  articulosDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Articulo> findById(long id) {
		return articulosDAO.findById(id);
	}

	@Override
	@Transactional
	public Articulo create(Articulo articulo) {
		return articulosDAO.save(articulo);
	}

	@Override
	@Transactional
	public boolean update(Articulo articulo) {
		
		Optional<Articulo> optionalArticulo = articulosDAO.findById(articulo.getId());
		
		if (optionalArticulo.isPresent()) {
			
			Articulo updateArticulo = optionalArticulo.get();
			updateArticulo.setNombre(articulo.getNombre());
			updateArticulo.setDescripcion(articulo.getDescripcion());
			articulosDAO.save(updateArticulo);
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
		articulosDAO.deleteById(id);
		
	}

}
