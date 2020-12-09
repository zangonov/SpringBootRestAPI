package com.init.practica.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.init.practica.entities.Usuario;
import java.util.Optional;

@Repository
public interface UsuariosDAO extends JpaRepository<Usuario,Long> {
	
	//@Query(value="select usuarios.* from usuarios where :queryString ", nativeQuery = true)
	@Query(value="select * from usuarios where usuario = ?1 and password = ?2 ", nativeQuery = true)
	public Optional<Usuario> findbyNombreAndPassword(String nombre, String password);

}
