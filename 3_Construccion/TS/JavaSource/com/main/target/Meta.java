package com.main.target;

// Generated 1/07/2013 11:59:54 PM by Hibernate Tools 3.4.0.CR1

/**
 * Meta generated by hbm2java
 */
public class Meta implements java.io.Serializable {

	private MetaId id;
	private Personal personal;

	public Meta() {
	}

	public Meta(MetaId id, Personal personal) {
		this.id = id;
		this.personal = personal;
	}

	public MetaId getId() {
		return this.id;
	}

	public void setId(MetaId id) {
		this.id = id;
	}

	public Personal getPersonal() {
		return this.personal;
	}

	public void setPersonal(Personal personal) {
		this.personal = personal;
	}

}
