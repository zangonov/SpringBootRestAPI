package com.init.practica.service;

import java.util.List;
import java.util.Optional;

import com.init.practica.entities.Usuario;

public interface UsuarioService {
	
	public List<Usuario> findAll();
	
	public Optional<Usuario> findById(long id);
	
	public Optional<Usuario> findByCredentials(String nombre, String password);
	
	public Usuario create(Usuario usuario);
	
	public boolean update(Usuario usuario);
	
	public void deleteById(Long id);

}
