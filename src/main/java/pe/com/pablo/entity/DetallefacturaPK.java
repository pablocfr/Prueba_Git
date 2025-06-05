package pe.com.pablo.entity;

import java.io.Serializable;
import jakarta.persistence.*;


@Embeddable
public class DetallefacturaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int numfactura;

	@Column(name="id_prod")
	private int idProd;

	public DetallefacturaPK() {
	}
	public int getNumfactura() {
		return this.numfactura;
	}
	public void setNumfactura(int numfactura) {
		this.numfactura = numfactura;
	}
	public int getIdProd() {
		return this.idProd;
	}
	public void setIdProd(int idProd) {
		this.idProd = idProd;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DetallefacturaPK)) {
			return false;
		}
		DetallefacturaPK castOther = (DetallefacturaPK)other;
		return 
			(this.numfactura == castOther.numfactura)
			&& (this.idProd == castOther.idProd);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.numfactura;
		hash = hash * prime + this.idProd;
		
		return hash;
	}
}