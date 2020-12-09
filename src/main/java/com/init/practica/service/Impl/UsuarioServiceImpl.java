package com.init.practica.service.Impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.init.practica.daos.UsuariosDAO;
import com.init.practica.entities.Usuario;
import com.init.practica.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	private static final Logger logger = LoggerFactory.getLogger(UsuarioServiceImpl.class);

	@Autowired
	private UsuariosDAO usuariosDAO;
	
	@Override
	public List<Usuario> findAll() {
		logger.debug("UsuarioServiceImpl.findAll ");
		return usuariosDAO.findAll();
	}
	
	@Override
	public Optional<Usuario> findById(long id) {
		logger.debug("UsuarioServiceImpl.findById " + id);
		return usuariosDAO.findById(id);
	}

	@Override
	public Optional<Usuario> findByCredentials(String nombre, String password) {
		logger.debug("UsuarioServiceImpl.findByCredentials ");

		return usuariosDAO.findbyNombreAndPassword(nombre,password);
	}

	@Override
	public Usuario create(Usuario usuario) {
		logger.debug("UsuarioServiceImpl.usuario ", usuario.toString());
		return usuariosDAO.save(usuario);
	}

	@Override
	public boolean update(Usuario usuario) {
		logger.debug("UsuarioServiceImpl.update ");
		return false;
	}

	@Override
	public void deleteById(Long id) {
		logger.debug("UsuarioServiceImpl.deleteById " + id);
		usuariosDAO.deleteById(id);
		
	}

}
