package pe.com.pablo.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.math.BigDecimal;

import lombok.Data;

@Data
@Entity
@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	private String descripcion;
	
	@Id
	@Column(name="id_prod")
	private int idProd;

	private BigDecimal precio;

	private int stock;

	public Producto() {
	}

}