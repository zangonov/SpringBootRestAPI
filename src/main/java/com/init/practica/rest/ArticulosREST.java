package com.init.practica.rest;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.init.practica.entities.Articulo;
import com.init.practica.service.ArticuloService;

@RestController
@RequestMapping("/api/articulo/")
@CrossOrigin()
public class ArticulosREST  {
	
	private static final Logger logger  = LoggerFactory.getLogger(ArticulosREST.class);
	
	@Autowired
	private ArticuloService articuloService;
	
	
	@GetMapping
	public ResponseEntity<List<Articulo>> getArticulos( )
	{	
		logger.debug("ArticulosREST.getArticulos");
		
		return ResponseEntity.ok(articuloService.findAll());	
	}
	
	@RequestMapping(value="pedido/{Id}")
	public ResponseEntity<List<Articulo>> getArticulosPedido( @PathVariable("Id") Long pedidoId)
	{	
		logger.debug("ArticulosREST.getArticulos del pedido " + pedidoId);
		
		return ResponseEntity.ok(articuloService.findAllByPedido(pedidoId));	
	}
	
	@RequestMapping(value="{Id}") //   /articulo/1
	public ResponseEntity<Articulo> getArticuloById(@PathVariable("Id") Long articuloId) {
		
		//Optional comprueba si el valor existe
		Optional<Articulo> optionalArticulo = articuloService.findById(articuloId);
		
		if (optionalArticulo.isPresent()) {
			
			return ResponseEntity.ok(optionalArticulo.get());	
		}
		else
		{
			return ResponseEntity.noContent().build(); 
		}
		
	}
	
	@PostMapping
	public ResponseEntity<Articulo> createArticulo(@RequestBody Articulo articulo) {
		
		return ResponseEntity.ok(articuloService.create(articulo));	
	}
	
	@DeleteMapping (value="{Id}") 
	public ResponseEntity<Void> deleteArticulo(@PathVariable("Id") Long articuloId) {
		
		Optional<Articulo> optionalArticulo = articuloService.findById(articuloId);
		
		if (optionalArticulo.isPresent()) {
			
			articuloService.deleteById(articuloId);
			return ResponseEntity.ok(null);	
		}
		else
		{
			return ResponseEntity.notFound().build(); 
		}
	}
	
	@PutMapping
	public ResponseEntity<Articulo> updateArticulo(@RequestBody Articulo articulo) {
		
		if (articuloService.update(articulo)) {
			return ResponseEntity.ok(articulo);	
		}
		else
		{
			return ResponseEntity.notFound().build(); 
		}
	}
	

}
