package com.init.practica.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	
	@Column(name="nombre", nullable=false, length = 50)
	private String nombre;
	
	@Column(name="apellidos", nullable=true , length = 50)
	private String apellidos;
	
	@Column(name="usuario", nullable=false, length = 30)
	private String usuario;
	
	@Column(name="password", nullable=false, length = 30)
	private String password;
	
	@Column(name="token", nullable=true, length = 256)
	private String token;
	
	@Column(name="role", nullable=true, length = 256)
	private String role;

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

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "Catalogo{" +
				"id=" + this.Id + '\'' +
				", nombre='" + this.nombre + '\'' +
				", apellidos='" + this.apellidos + '\'' +
				", usuario='" + this.usuario + '\'' +
				", role='" + this.role + '\'' +
				'}';
	}
	
}