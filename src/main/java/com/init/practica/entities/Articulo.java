package com.init.practica.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Table(name="articulos")
public class Articulo {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	
	@Column(name="nombre", nullable=false, length = 30)
	private String nombre;
	
	@Column(name="descripcion", nullable=false, length = 256)
	private String descripcion;
	
	@Column(name="precio", nullable=true)
	private float precio;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "id_catalogo", referencedColumnName = "id")
    private Catalogo catalogo;
	
	@OneToMany(mappedBy = "articulo")
    Set<ArticulosPedido> articulosPedido;

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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Catalogo getCatalogo() {
		return catalogo;
	}

	public void setCatalogo(Catalogo catalogo) {
		this.catalogo = catalogo;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}


	public Articulo(String nombre, String descripcion, Catalogo catalogo) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.catalogo = catalogo;
	}
	

	public Articulo() {
	}
	

	@Override
	public String toString() {
		String texto= "Articulo{" +
				"id=" + this.Id +
				", nombre='" + this.nombre + '\'' +
				", descripcion='" + this.descripcion + '\'';
				if (this.catalogo != null) {
				texto += ", catalogo='" + this.catalogo.getNombre() + '\'' ; 
				}
				texto += +'}';
					
		return texto;
	}
	

}
