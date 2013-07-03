package com.main.target;

// Generated 2/07/2013 10:20:52 PM by Hibernate Tools 3.4.0.CR1

/**
 * CatalogoProveedorId generated by hbm2java
 */
public class CatalogoProveedorId implements java.io.Serializable {

	private String idProveedor;
	private int tipoProveedor;

	public CatalogoProveedorId() {
	}

	public CatalogoProveedorId(String idProveedor, int tipoProveedor) {
		this.idProveedor = idProveedor;
		this.tipoProveedor = tipoProveedor;
	}

	public String getIdProveedor() {
		return this.idProveedor;
	}

	public void setIdProveedor(String idProveedor) {
		this.idProveedor = idProveedor;
	}

	public int getTipoProveedor() {
		return this.tipoProveedor;
	}

	public void setTipoProveedor(int tipoProveedor) {
		this.tipoProveedor = tipoProveedor;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CatalogoProveedorId))
			return false;
		CatalogoProveedorId castOther = (CatalogoProveedorId) other;

		return ((this.getIdProveedor() == castOther.getIdProveedor()) || (this
				.getIdProveedor() != null && castOther.getIdProveedor() != null && this
				.getIdProveedor().equals(castOther.getIdProveedor())))
				&& (this.getTipoProveedor() == castOther.getTipoProveedor());
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getIdProveedor() == null ? 0 : this.getIdProveedor()
						.hashCode());
		result = 37 * result + this.getTipoProveedor();
		return result;
	}

}
