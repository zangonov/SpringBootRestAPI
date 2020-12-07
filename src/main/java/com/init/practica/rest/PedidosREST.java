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

import com.init.practica.entities.Pedido;
import com.init.practica.service.PedidoService;

@RestController
@RequestMapping("/api/pedido/")
@CrossOrigin()
public class PedidosREST {
	
	@Autowired
	private PedidoService pedidoService;

	@GetMapping
	public ResponseEntity<List<Pedido>> getPedidos() {

		return ResponseEntity.ok(pedidoService.findAll());	
	}
	
	
	@RequestMapping(value="{Id}") //   /pedido/1
	public ResponseEntity<Pedido> getPedidoById(@PathVariable("Id") Long catalogoId) {
		
		//Optional comprueba si el valor existe
		Optional<Pedido> optionalCatalogo = pedidoService.findById(catalogoId);
		
		if (optionalCatalogo.isPresent()) {
			
			return ResponseEntity.ok(optionalCatalogo.get());	
		}
		else
		{
			return ResponseEntity.noContent().build(); 
		}
		
	}
	
	@PostMapping
	public ResponseEntity<Pedido> createPedido(@RequestBody Pedido pedido) {
		
		return ResponseEntity.ok(pedidoService.create(pedido));	
	}
	
	@DeleteMapping (value="{Id}") 
	public ResponseEntity<Void> deletePedido(@PathVariable("Id") Long pedidoId) {
		
		Optional<Pedido> optionalPedido = pedidoService.findById(pedidoId);
		
		if (optionalPedido.isPresent()) {
			
			pedidoService.deleteById(pedidoId);
			return ResponseEntity.ok(null);	
		}
		else
		{
			return ResponseEntity.notFound().build(); 
		}
	}
	
	@PutMapping
	public ResponseEntity<Pedido> updatePedido(@RequestBody Pedido pedido) {
		
		if (pedidoService.update(pedido)) {
			return ResponseEntity.ok(pedido);	
		}
		else
		{
			return ResponseEntity.notFound().build(); 
		}
	}
}