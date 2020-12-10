package com.init.practica.service.Impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.init.practica.daos.ArticulosDAO;
import com.init.practica.daos.CatalogosDAO;
import com.init.practica.entities.Articulo;
import com.init.practica.entities.Catalogo;
import com.init.practica.service.CatalogoService;

@Service
public class CatalogoServiceImpl implements CatalogoService{

	private static final Logger logger = LoggerFactory.getLogger(CatalogoServiceImpl.class);
	
	@Autowired
	private CatalogosDAO catalogosDAO;
	
	@Autowired
	private ArticulosDAO articulosDAO;
	
	public CatalogoServiceImpl() {	
		super();
	}
	
	@Override
	public List<Catalogo> findAll() {
		logger.debug("CatalogoServiceImpl.findAll ");
		return catalogosDAO.findAll();
	}

	@Override
	public Optional<Catalogo> findById(Long id) {
		logger.debug("CatalogoServiceImpl.findById " + id);
		return catalogosDAO.findById(id);
	}

	@Override
	public Catalogo create(Catalogo catalogo) {
		logger.debug("CatalogoServiceImpl.create " + catalogo.toString());
		return catalogosDAO.save(catalogo);
	}

	@Override
	public boolean update(Catalogo catalogo) {
		logger.debug("CatalogoServiceImpl.update "+ catalogo.toString());
		Optional<Catalogo> optionalCatalogo = catalogosDAO.findById(catalogo.getId());
		
		if (optionalCatalogo.isPresent()) {
			
			Catalogo updateCatalogo = optionalCatalogo.get();
			updateCatalogo.setNombre(catalogo.getNombre());
			catalogosDAO.save(updateCatalogo);
			return true;	
		}
		else
		{
			return false; 
		}
	}

	@Override
	public boolean deleteById(Long id) {
		logger.debug("CatalogoServiceImpl.deleteById " + id);
		List<Articulo> list = articulosDAO.findAllByCatalogueId(id);
		if (list.size() ==0) {
			catalogosDAO.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
}
