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
@Table(name="pedidos")
public class Pedido {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	
	@Column(name="nombre", nullable=false, length = 30)
	private String nombre;
	
	@Column(name="total", nullable=true)
	private float total;
	
	@OneToMany(mappedBy = "pedido", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    Set<ArticulosPedido> articulosPedido;

	public Long getId() {
		return Id;
	}

	public float getTotal() {
		this.total = 0;

		for (ArticulosPedido obj : articulosPedido) {
			if (obj.getArticulo() != null)
				total += obj.cantidad * obj.getArticulo().getPrecio();
		}

		return total;
	}

	public void setTotal(float total) {
		this.total = total;
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

	//public Set<ArticulosPedido> getArticulosPedido() {
	//	return articulosPedido;
	//}

	public void setArticulosPedido(Set<ArticulosPedido> articulosPedido) {
		this.articulosPedido = articulosPedido;
	}


}
