package com.init.practica.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.init.practica.daos.CatalogosDAO;
import com.init.practica.entities.Catalogo;
import com.init.practica.service.CatalogoService;

@Service
public class CatalogoServiceImpl implements CatalogoService{

	@Autowired
	private CatalogosDAO catalogosDAO;
	
	public CatalogoServiceImpl() {	
		super();
	}
	
	@Override
	public List<Catalogo> findAll() {
		return catalogosDAO.findAll();
	}

	@Override
	public Optional<Catalogo> findById(Long id) {
		return catalogosDAO.findById(id);
	}

	@Override
	public Catalogo create(Catalogo catalogo) {
		return catalogosDAO.save(catalogo);
	}

	@Override
	public boolean update(Catalogo catalogo) {
		
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
	public void deleteById(Long id) {
		catalogosDAO.deleteById(id);
		
	}
}
