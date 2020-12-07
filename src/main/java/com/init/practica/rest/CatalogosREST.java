package com.init.practica.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.init.practica.entities.Catalogo;
import com.init.practica.service.CatalogoService;

@RestController
@RequestMapping("/api/catalogo/")
@CrossOrigin()
public class CatalogosREST {
	
	@Autowired
	private CatalogoService catalogoService;

	@GetMapping
	public ResponseEntity<List<Catalogo>> getCatalogos() {
			
		return ResponseEntity.ok(catalogoService.findAll());
	}
	
	
	@RequestMapping(value="{Id}") //   /catalogo/1
	public ResponseEntity<Catalogo> getCatalogoloById(@PathVariable("Id") Long catalogoId) {
		
		//Optional comprueba si el valor existe
		Optional<Catalogo> optionalCatalogo = catalogoService.findById(catalogoId);
		
		if (optionalCatalogo.isPresent()) {
			
			return ResponseEntity.ok(optionalCatalogo.get());	
		}
		else
		{
			return ResponseEntity.noContent().build(); 
		}
		
	}
	
	@PostMapping
	public ResponseEntity<Catalogo> createCatalogo(@RequestBody Catalogo catalogo) {
		
		return ResponseEntity.ok( catalogoService.create(catalogo));	
	}
	
	@DeleteMapping (value="{Id}") 
	public ResponseEntity<Void> deleteCatalogo(@PathVariable("Id") Long catalogoId) {
		
		Optional<Catalogo> optionalCatalogo = catalogoService.findById(catalogoId);
		
		if (optionalCatalogo.isPresent()) {
			catalogoService.deleteById(catalogoId);
			return ResponseEntity.ok(null);	
		}
		else
		{
			return ResponseEntity.notFound().build(); 
		}
	}
	
	@PutMapping
	public ResponseEntity<Catalogo> updateCatalogo(@RequestBody Catalogo catalogo) {
		
		if (catalogoService.update(catalogo)) {
			return ResponseEntity.ok(catalogo);	
		}
		else
		{
			return ResponseEntity.notFound().build(); 
		}
	}
}
