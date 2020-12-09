package com.init.practica.daos;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.init.practica.entities.Catalogo;

@Repository
public interface CatalogosDAO extends JpaRepository<Catalogo,Long> {

}
