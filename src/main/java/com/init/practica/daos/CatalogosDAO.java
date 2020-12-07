package com.init.practica.daos;


import org.springframework.data.jpa.repository.JpaRepository;

import com.init.practica.entities.Catalogo;

public interface CatalogosDAO extends JpaRepository<Catalogo,Long> {

}
