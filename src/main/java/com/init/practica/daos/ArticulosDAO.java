package com.init.practica.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.init.practica.entities.Articulo;

@Repository
public interface ArticulosDAO extends JpaRepository<Articulo,Long>{
	
	@Query(value="select * from articulos where id_catalogo = ?1", nativeQuery = true)
	List<Articulo> findAllByCatalogueId(Long catalogue_id);
	
	@Query(value="select a.* from articulos as a inner join articulos_pedidos as ap on ap.articulo_id = a.id where articulo_id =  ?1", nativeQuery = true)
	List<Articulo> findAllByArticuloIdPedido(Long articulo_id);


}
