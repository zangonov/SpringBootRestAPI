package com.init.practica;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.init.practica.entities.Catalogo;
import com.init.practica.service.CatalogoService;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TestCategoria {
    
	@Autowired    
	TestEntityManager entityManager;    
	
	@Autowired    
	private CatalogoService catalogoService;   
	
	@Test    
	public void it_should_save_user() 
	{        
		 Catalogo catalogo = new Catalogo(); 
		 catalogo.setNombre("catalogo test"); 
		 catalogo = entityManager.persistAndFlush(catalogo);
		 assertThat(catalogoService.findById(catalogo.getId()).get()).isEqualTo(  catalogo); 
	}
}

