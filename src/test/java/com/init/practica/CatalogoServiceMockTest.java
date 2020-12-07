package com.init.practica;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
 
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;
import com.init.practica.daos.CatalogosDAO;
import com.init.practica.entities.Catalogo;
import com.init.practica.service.CatalogoService;



@RunWith(MockitoJUnitRunner.class)
public class CatalogoServiceMockTest {

    @Mock
    private CatalogoService catalogoService; 
    
    @Mock
    private CatalogosDAO catalogosDAO;
    
   // variable inOrder de mockito para comprobar llamadas en orden
    private InOrder ordered;
    //@Before
    //public void init() {
    //    MockitoAnnotations.initMocks(this);
    //}

    @DisplayName("Test Mock catalogoService + catalogosDAO")
    @Test
    void testGet() {
    	
    	Optional<Catalogo> catalogo =  Optional.of(new Catalogo ("catalogo"));
    	when(catalogoService.findById(1L)).thenReturn(catalogo); 
    	//{"'nombre':'nombre 1','descripcion':'descripcion 1','precio':7.0,'catalogo':{'nombre':'catalogo 1','id':1},'id':1"});
       
    	ordered.verify(catalogosDAO).findById(1L).get().getId();
    	
    	//getAuthData(catalogo.get().getId());
    	
    	//Catalogo catalogo = new Catalogo();
    	//catalogo.setNombre("nombre creado");
    	//catalogo.setId(10L);
    	//Set<Articulo> articulos = new HashSet<Articulo>();
    	//catalogo.setArticulos(articulos);
		//catalogoService.create(catalogo);
		
		//verify(catalogosDAO, times(1)).save(catalogo);

    }
	
}
