package com.init.practica.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.init.practica.entities.Pedido;

@Repository
public interface PedidosDAO extends JpaRepository<Pedido,Long>{

}