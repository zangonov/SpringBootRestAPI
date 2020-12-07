package com.init.practica;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.mock.mockito.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.init.practica.entities.Catalogo;


@RunWith(SpringRunner.class)
//@SpringBootTest(classes = PracticaRicohApplication.class,webEnvironment = WebEnvironment.RANDOM_PORT)
@SpringBootTest(classes = PracticaRicohApplication.class)
public class RepostoriesTest {
	
	
	//@LocalServerPort
    //private int port ;
	
    //@Autowired
    //private TestRestTemplate restTemplate;
    
    @Autowired
    private WebApplicationContext wac;
    
    private MockMvc mockMvc;
    /**
     * 
     *     @Test
    public void testAllCatalogos() 
    {
    	System.out.println(this.restTemplate
        .getForObject("http://localhost:8080/api/catalogo/1", Catalogo.class).getId());
    	System.out.println("http://localhost:\" + port + \"/api/catalogo/");
    	System.out.println("http://localhost:8080/api/catalogo/");
        assertTrue(
        		this.restTemplate
                .getForObject("http://localhost:8080/api/catalogo/1", Catalogo.class)
                .getId() == 1);
    }	
     * @throws Exception
     */
    
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
	public void testGetCatalogosEndpointIsOK() throws Exception {
        this.mockMvc.perform(get("/api/catalogo/"))
            .andExpect(status().isOk());
	}
}
