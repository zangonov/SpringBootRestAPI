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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.init.practica.entities.Pedido;
import com.init.practica.service.PedidoService;

@RestController
@RequestMapping("/api/pedido/")
@CrossOrigin()
public class PedidosREST {
	
	private static final Logger logger = LoggerFactory.getLogger(PedidosREST.class);
	
	@Autowired
	private PedidoService pedidoService;

	@GetMapping
	public ResponseEntity<List<Pedido>> getPedidos() {
		
		logger.debug("PedidosREST.getPedidos ");
		
		return ResponseEntity.ok(pedidoService.findAll());	
	}
	
	
	@RequestMapping(value="{Id}", method = RequestMethod.GET) //   /pedido/1
	public ResponseEntity<Pedido> getPedidoById(@PathVariable("Id") Long pedidoId) {
		
		logger.debug("PedidosREST.getPedidoById " + pedidoId);
		
		//Optional comprueba si el valor existe
		Optional<Pedido> optionalPedido = pedidoService.findById(pedidoId);
		
		if (optionalPedido.isPresent()) {
			return ResponseEntity.ok(optionalPedido.get());	
		}
		else {
			return ResponseEntity.noContent().build(); 
		}
	}
	
	@PostMapping
	public ResponseEntity<Pedido> createPedido(@RequestBody Pedido pedido) {
		
		logger.debug("PedidosREST.createPedido " + pedido.toString());
		
		Pedido pedidoCreado = pedidoService.create(pedido);
		
		return ResponseEntity.ok(pedidoCreado);	
	}
	
	@DeleteMapping (value="{Id}") 
	public ResponseEntity<Void> deletePedido(@PathVariable("Id") Long pedidoId) {
		
		logger.debug("PedidosREST.deletePedido " + pedidoId);
		
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
		
		logger.debug("PedidosREST.updatePedido " + pedido.toString());
		
		if (pedidoService.update(pedido)) {
			return ResponseEntity.ok(pedido);	
		}
		else
		{
			return ResponseEntity.notFound().build(); 
		}
	}
}