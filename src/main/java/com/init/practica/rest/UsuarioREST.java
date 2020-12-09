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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.init.practica.entities.Usuario;
import com.init.practica.service.UsuarioService;

@RestController
@RequestMapping("/api/usuario/")
@CrossOrigin()
public class UsuarioREST {
	
	@Autowired
	private UsuarioService usuarioService;

	@GetMapping
	public ResponseEntity<List<Usuario>> getPedidos() {

		return ResponseEntity.ok(usuarioService.findAll());	
	}
	
	@RequestMapping(value="/{usuario}/{password}", method = RequestMethod.GET) //   /usuario/paswword
	public ResponseEntity<Usuario> findByCredentials(
				@PathVariable("usuario") String usuario, 
				@PathVariable("password") String password) {
		
		//Optional comprueba si el valor existe
		Optional<Usuario> optionalUsuario = usuarioService.findByCredentials(usuario, password);
		
		if (optionalUsuario.isPresent()) {
			return ResponseEntity.ok(optionalUsuario.get());	
		}
		else
		{
			return ResponseEntity.noContent().build(); 
		}
	}
	
	@RequestMapping(value="{Id}", method = RequestMethod.GET) //   /usuario/1
	public ResponseEntity<Usuario> getUsuarioById(@PathVariable("Id") Long usuarioId) {
		
		//Optional comprueba si el valor existe
		Optional<Usuario> optionalUsuario = usuarioService.findById(usuarioId);
		
		if (optionalUsuario.isPresent()) {
			
			return ResponseEntity.ok(optionalUsuario.get());	
		}
		else
		{
			return ResponseEntity.noContent().build(); 
		}
		
	}
	
	@PostMapping
	public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) {
		
		return ResponseEntity.ok(usuarioService.create(usuario));	
	}
	
	@DeleteMapping (value="{Id}") 
	public ResponseEntity<Void> deleteUsuario(@PathVariable("Id") Long usuarioId) {
		
		Optional<Usuario> optionalUsuario = usuarioService.findById(usuarioId);
		
		if (optionalUsuario.isPresent()) {
			
			usuarioService.deleteById(usuarioId);
			return ResponseEntity.ok(null);	
		}
		else
		{
			return ResponseEntity.notFound().build(); 
		}
	}
	
	@PutMapping
	public ResponseEntity<Usuario> updateUsuario(@RequestBody Usuario usuario) {
		
		if (usuarioService.update(usuario)) {
			return ResponseEntity.ok(usuario);	
		}
		else
		{
			return ResponseEntity.notFound().build(); 
		}
	}
}
