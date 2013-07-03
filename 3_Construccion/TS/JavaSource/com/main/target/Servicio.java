package com.main.target;

// Generated 2/07/2013 10:20:52 PM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * Servicio generated by hbm2java
 */
public class Servicio implements java.io.Serializable {

	private String idServicio;
	private String concepto;
	private String descripcion;
	private int esfacturable;
	private Set TNotas = new HashSet(0);

	public Servicio() {
	}

	public Servicio(String idServicio, String concepto, int esfacturable) {
		this.idServicio = idServicio;
		this.concepto = concepto;
		this.esfacturable = esfacturable;
	}

	public Servicio(String idServicio, String concepto, String descripcion,
			int esfacturable, Set TNotas) {
		this.idServicio = idServicio;
		this.concepto = concepto;
		this.descripcion = descripcion;
		this.esfacturable = esfacturable;
		this.TNotas = TNotas;
	}

	public String getIdServicio() {
		return this.idServicio;
	}

	public void setIdServicio(String idServicio) {
		this.idServicio = idServicio;
	}

	public String getConcepto() {
		return this.concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getEsfacturable() {
		return this.esfacturable;
	}

	public void setEsfacturable(int esfacturable) {
		this.esfacturable = esfacturable;
	}

	public Set getTNotas() {
		return this.TNotas;
	}

	public void setTNotas(Set TNotas) {
		this.TNotas = TNotas;
	}

}