package com.init.practica.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@Table(name="catalogos")
public class Catalogo {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	
	@Column(name="nombre", nullable=false, length = 30)
	private String nombre;
	
	@OneToMany(mappedBy="catalogo", fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private Set<Articulo> articulos;
	

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setArticulos(Set<Articulo> articulos) {
		this.articulos = articulos;
	}

	public Catalogo(String nombre) {
		super();
		this.nombre = nombre;
	}
	public Catalogo() {
	}


	@Override
	public String toString() {
		return "Catalogo{" +
				"id=" + Id +
				", nombre='" + nombre + '\'' +
				'}';
	}
}
