package pe.com.pablo.entity;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the detallefactura database table.
 * 
 */
@Entity
@NamedQuery(name="Detallefactura.findAll", query="SELECT d FROM Detallefactura d")
public class Detallefactura implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DetallefacturaPK id;

	private int cantidad;

	//bi-directional many-to-one association to Factura
	@ManyToOne
	@JoinColumn(name="numfactura")
	private Factura factura;

	public Detallefactura() {
	}

	public DetallefacturaPK getId() {
		return this.id;
	}

	public void setId(DetallefacturaPK id) {
		this.id = id;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Factura getFactura() {
		return this.factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

}