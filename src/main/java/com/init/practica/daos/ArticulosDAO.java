package com.init.practica.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.init.practica.entities.Articulo;


public interface ArticulosDAO extends JpaRepository<Articulo,Long>{
	
	//@Query("select a.Id from articulos as a inner join articulos_pedidos as at on a.id = at.articulo_id where at.pedido_id = :id")
	@Query(value="select a.* from articulos as a inner join articulos_pedidos as at on a.id = at.articulo_id where at.pedido_id = :id", nativeQuery = true)
	public List<Articulo> findAllByPedido (Long id);

}
