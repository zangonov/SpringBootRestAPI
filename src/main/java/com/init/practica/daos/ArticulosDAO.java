package com.init.practica.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.init.practica.entities.Articulo;

@Repository
public interface ArticulosDAO extends JpaRepository<Articulo,Long>{

}
