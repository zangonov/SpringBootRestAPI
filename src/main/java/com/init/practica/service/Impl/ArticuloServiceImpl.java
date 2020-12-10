package com.init.practica.service.Impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.init.practica.daos.ArticulosDAO;
import com.init.practica.entities.Articulo;
import com.init.practica.service.ArticuloService;

@Service
public class ArticuloServiceImpl  implements ArticuloService{
	
	private static final Logger logger = LoggerFactory.getLogger(ArticuloServiceImpl.class);
	
	@Autowired
	private ArticulosDAO articulosDAO;

	@Override
	@Transactional(readOnly = true)
	public List<Articulo> findAll() {
		logger.debug("ArticuloServiceImpl.findAll");
		return  articulosDAO.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Articulo> findAllByCatalogo(long CatalogoId) {
		
		return articulosDAO.findAllByCatalogueId(CatalogoId);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Articulo> findAllByArticuloIdPedido(long articuloId) {
		
		return articulosDAO.findAllByArticuloIdPedido(articuloId);
	}

	
	
	@Override
	@Transactional(readOnly = true)
	public Optional<Articulo> findById(long id) {
		logger.debug("ArticuloServiceImpl.findById", id);
		return articulosDAO.findById(id);
	}

	@Override
	@Transactional
	public Articulo create(Articulo articulo) {
		logger.debug("ArticuloServiceImpl.create");
		return articulosDAO.save(articulo);
	}

	@Override
	@Transactional
	public boolean update(Articulo articulo) {
		logger.debug("ArticuloServiceImpl.update " + articulo.toString());
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
		logger.debug("ArticuloServiceImpl.delete "  +id);
		articulosDAO.deleteById(id);
	}

}
