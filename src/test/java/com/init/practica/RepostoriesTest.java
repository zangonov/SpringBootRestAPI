package com.init.practica;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.*;
import org.junit.runner.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
	
	
@RunWith(SpringRunner.class)
@SpringBootTest(classes = PracticaRicohApplication.class)
public class RepostoriesTest {
	

    @Autowired
    private WebApplicationContext wac;
    
    private MockMvc mockMvc;
    
    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }
    
    @Test
	public void testGetCatalogoEndpointIsOK() throws Exception {
        this.mockMvc.perform(get("/api/catalogo/1"))
            .andExpect(status().isOk());
	}
    
    @Test
	public void testGetArticuloEndpointIsOK() throws Exception {
        this.mockMvc.perform(get("/api/articulo/1"))
            .andExpect(status().isOk());
	}
    
    @Test
	public void testGetPedidoEndpointIsOK() throws Exception {
        this.mockMvc.perform(get("/api/pedido/1"))
            .andExpect(status().isOk());
	}
    
    @Test
	public void testGetArticulosEndpointIsOK() throws Exception {
        this.mockMvc.perform(get("/api/articulo/"))
            .andExpect(status().isOk());
	}
    
    @Test
	public void testGetCatalogosEndpointIsOK() throws Exception {
        this.mockMvc.perform(get("/api/catalogo/"))
            .andExpect(status().isOk());
	}
	
    @Test
	public void testGetPedidosEndpointIsOK() throws Exception {
        this.mockMvc.perform(get("/api/pedido/"))
            .andExpect(status().isOk());
	}
	
}
