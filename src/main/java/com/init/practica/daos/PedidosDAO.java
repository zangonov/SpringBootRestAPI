package com.init.practica.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.init.practica.entities.Pedido;

public interface PedidosDAO extends JpaRepository<Pedido,Long>{

}