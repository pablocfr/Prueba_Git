package pe.com.pablo.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import pe.com.pablo.entity.*;
import pe.edu.cibertec.t1.entity.Cliente;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the factura database table.
 * 
 */
@Entity
@NamedQuery(name="Factura.findAll", query="SELECT f FROM Factura f")
public class Factura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int numfactura;

	private String estado;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private double total;

	//bi-directional many-to-one association to DetalleFactura
	@OneToMany(mappedBy="factura")
	private List<Detallefactura> detalleFacturas;

		//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente cliente;

	public Factura() {
	}

	public int getNumfactura() {
		return this.numfactura;
	}

	public void setNumfactura(int numfactura) {
		this.numfactura = numfactura;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public double getTotal() {
		return this.total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public List<Detallefactura> getDetallefacturas() {
		return this.detallefacturas;
	}

	public void setDetallefacturas(List<Detallefactura> detallefacturas) {
		this.detallefacturas = detallefacturas;
	}

	public Detallefactura addDetallefactura(Detallefactura detallefactura) {
		getDetallefacturas().add(detallefactura);
		detallefactura.setFactura(this);

		return detallefactura;
	}

	public Detallefactura removeDetallefactura(Detallefactura detallefactura) {
		getDetallefacturas().remove(detallefactura);
		detallefactura.setFactura(null);

		return detallefactura;
	}
	
	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}