package com.init.practica;

import static org.junit.Assert.assertTrue;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;

import com.init.practica.entities.Articulo;
import com.init.practica.entities.Catalogo;
import com.init.practica.entities.Pedido;
import com.init.practica.service.ArticuloService;
import com.init.practica.service.CatalogoService;
import com.init.practica.service.PedidoService;


/**
 * @author jose
 *
 */
@SpringBootTest
class PracticaRicohApplicationTests {


	@Autowired
	private ArticuloService articuloService;
	
	@Autowired
	private CatalogoService catalogoService;
	
	@Autowired
	private PedidoService pedidoService;
	/*
	 * Catalogos
	 */
	
	 @DisplayName("Test Spring GetAll Catalogos")
	 @Test
	 void testGetAllCatalogos() {
		 List<Catalogo> list = catalogoService.findAll();
		 assertTrue(list.size() >0);
	 }
	 
	 @DisplayName("Test Spring Get Catalogo")
	 @Test
	 void testGetCatalogo() {
		 
		 Optional<Catalogo> catalogo = catalogoService.findById(1L);
	     assertTrue(catalogo.get().getId() != null);
	 }
	 
	 @DisplayName("Test Spring Create Catalogo")
	 @Test
	 void testCreateCatalogo() {
		 		
		Catalogo catalogo = new Catalogo();
		catalogo.setNombre("catalogo creado");
		System.out.println(catalogo.toString());
		
		catalogoService.create(catalogo);
		
		System.out.println(catalogo.toString());
		
		assertTrue(catalogo.getId()>0);

	 }
	 
	 @DisplayName("Test Spring Update Catalogo")
	 @Test
	 void testUpdateCatalogo() {
		 		
		Optional<Catalogo> catalogo = catalogoService.findById(1L);
		
		Catalogo catalogoUpdate = catalogo.get();
		catalogoUpdate.setNombre("Catalogo modificado");
				
		assertTrue(catalogoService.update(catalogoUpdate)); 

	 }
	 
	 @DisplayName("Test Spring Delete Catalogo")
	 @Test
	 void testDeleteCatalogo() {
		 		
		long id = 3L;
		 
		Optional<Catalogo> optionalCatalogo = catalogoService.findById(id);
		
		if (optionalCatalogo.isPresent()) {
			
			catalogoService.deleteById(id);
			assertTrue(true);	
		}
		else
		{
			assertTrue(false);
		}
	 }
	 
	 /*
	  * Articulos
	  * 
	  */
	 
	 @DisplayName("Test Spring GetAll Articulos")
	 @Test
	 void testGetAllArticulos() {
		 
		 List<Articulo> list = articuloService.findAll();
	     assertTrue(list.size() >0);
	 }
	 
	 @DisplayName("Test Spring Get Articulo")
	 @Test
	 void testGetArticulo() {
		 
		 Optional<Articulo> articuloOptional = articuloService.findById(1L);
		 Articulo articulo = articuloOptional.get();
		 
	     assertTrue(articulo.getId() != null);
	 }
	 
	 @DisplayName("Test Spring Update Articulo")
	 @Test
	 void testUpdateArticulo() {
		 
		Optional<Articulo> articulo = articuloService.findById(1L);
		
		Articulo articuloUpdate = articulo.get();
		articuloUpdate.setDescripcion("descripcion modificada");
				
		assertTrue(articuloService.update(articuloUpdate));

	 }
	 
	 @DisplayName("Test Spring Create Articulo")
	 @Test
	 void testCreateArticulo() {
		 		
		Articulo articulo = new Articulo();
		Optional<Catalogo> catalogo = catalogoService.findById(1L);
		
		System.out.println(articulo.toString());
		//articulo.setId(6L);
		articulo.setNombre("nombre creado");
		articulo.setDescripcion("descripcion creada");
		articulo.setPrecio((float) 15.0);
		articulo.setCatalogo(catalogo.get());
		System.out.println(articulo.toString());
		
		articuloService.create(articulo);
		
		System.out.println(articulo.toString());
		
		assertTrue(articulo.getId()>0);

	 }

	 
	 @DisplayName("Test Spring Delete Articulo")
	 @Test
	 void testDeleteArticulo() {
		 		
		long id = 6L;
		 
		Optional<Articulo> optionalArticulo= articuloService.findById(id);
		
		if (optionalArticulo.isPresent()) {
			
			articuloService.deleteById(id);
			assertTrue(true);	
		}
		else
		{
			assertTrue(false);
		}
	 }
	 
	 /*
	  * Pedidos
	  * 
	  */
	 
	 @DisplayName("Test Spring GetAll Pedidos")
	 @Test
	 void testGetAllPedidos() {
		 
		 List<Pedido> list = pedidoService.findAll();
	     assertTrue(list.size() >0);
	 }
	 
	 @DisplayName("Test Spring Get Pedido")
	 @Test
	 void testGetPedido() {
		 
		 Optional<Pedido> pedidoOptional = pedidoService.findById(1L);
		 Pedido pedido = pedidoOptional.get();
		 
	     assertTrue(pedido.getId() != null);
	 }
	
}
