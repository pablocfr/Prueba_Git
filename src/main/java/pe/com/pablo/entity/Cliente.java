package pe.com.pablo.entity;

import java.io.Serializable;
import jakarta.persistence.*;

import lombok.Data;

@Entity
@Data
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_cliente")
	private int idCliente;

	private String nombre;
	private String direcicon;

	public Cliente() {
	}
	
	@Override
	public String toString() {
		return nombre;
	}
}