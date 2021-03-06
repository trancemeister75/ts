package com.main.target;

// Generated 2/07/2013 10:20:52 PM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * Proveedor generated by hbm2java
 */
public class Proveedor implements java.io.Serializable {

	private String rfc;
	private String nombre;
	private String domicilioFiscal;
	private Integer telefono;
	private Set catalogoProveedors = new HashSet(0);
	private Set catalogoProductos = new HashSet(0);

	public Proveedor() {
	}

	public Proveedor(String rfc, String nombre) {
		this.rfc = rfc;
		this.nombre = nombre;
	}

	public Proveedor(String rfc, String nombre, String domicilioFiscal,
			Integer telefono, Set catalogoProveedors, Set catalogoProductos) {
		this.rfc = rfc;
		this.nombre = nombre;
		this.domicilioFiscal = domicilioFiscal;
		this.telefono = telefono;
		this.catalogoProveedors = catalogoProveedors;
		this.catalogoProductos = catalogoProductos;
	}

	public String getRfc() {
		return this.rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDomicilioFiscal() {
		return this.domicilioFiscal;
	}

	public void setDomicilioFiscal(String domicilioFiscal) {
		this.domicilioFiscal = domicilioFiscal;
	}

	public Integer getTelefono() {
		return this.telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public Set getCatalogoProveedors() {
		return this.catalogoProveedors;
	}

	public void setCatalogoProveedors(Set catalogoProveedors) {
		this.catalogoProveedors = catalogoProveedors;
	}

	public Set getCatalogoProductos() {
		return this.catalogoProductos;
	}

	public void setCatalogoProductos(Set catalogoProductos) {
		this.catalogoProductos = catalogoProductos;
	}

}
