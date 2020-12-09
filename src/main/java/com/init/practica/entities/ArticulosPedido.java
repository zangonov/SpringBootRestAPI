package com.init.practica.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="articulosPedidos")
public class ArticulosPedido {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    long id;
    
	@Column(name="cantidad")
    int cantidad;

    @ManyToOne
    @JoinColumn(name = "articulo_id")
    Articulo articulo;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    @JsonBackReference
    Pedido pedido;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public ArticulosPedido(int cantidad, Articulo articulo, Pedido pedido) {
		this.cantidad = cantidad;
		this.articulo = articulo;
		this.pedido = pedido;
	}
	
	public ArticulosPedido() {
		super();
	}

}
