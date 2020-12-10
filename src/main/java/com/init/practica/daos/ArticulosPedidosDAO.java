package com.init.practica.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.init.practica.entities.ArticulosPedido;

@Repository
public interface ArticulosPedidosDAO extends JpaRepository<ArticulosPedido,Long>{
	

}
