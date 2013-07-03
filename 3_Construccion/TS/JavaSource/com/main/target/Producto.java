package com.main.target;

// Generated 2/07/2013 10:20:52 PM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * Producto generated by hbm2java
 */
public class Producto implements java.io.Serializable {

	private String idProducto;
	private String nombre;
	private String descripcion;
	private int idMarca;
	private String categoria;
	private Set catalogoProductos = new HashSet(0);
	private Set TNotas = new HashSet(0);

	public Producto() {
	}

	public Producto(String idProducto, String nombre, String descripcion,
			int idMarca) {
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.idMarca = idMarca;
	}

	public Producto(String idProducto, String nombre, String descripcion,
			int idMarca, String categoria, Set catalogoProductos, Set TNotas) {
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.idMarca = idMarca;
		this.categoria = categoria;
		this.catalogoProductos = catalogoProductos;
		this.TNotas = TNotas;
	}

	public String getIdProducto() {
		return this.idProducto;
	}

	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getIdMarca() {
		return this.idMarca;
	}

	public void setIdMarca(int idMarca) {
		this.idMarca = idMarca;
	}

	public String getCategoria() {
		return this.categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Set getCatalogoProductos() {
		return this.catalogoProductos;
	}

	public void setCatalogoProductos(Set catalogoProductos) {
		this.catalogoProductos = catalogoProductos;
	}

	public Set getTNotas() {
		return this.TNotas;
	}

	public void setTNotas(Set TNotas) {
		this.TNotas = TNotas;
	}

}