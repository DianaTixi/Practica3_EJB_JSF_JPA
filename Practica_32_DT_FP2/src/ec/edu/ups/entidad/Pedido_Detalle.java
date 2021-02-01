package ec.edu.ups.entidad;

import java.io.Serializable;

import javax.json.bind.annotation.JsonbProperty;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Pedido_Detalle implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonbProperty
	private int num_detalle;
	@JsonbProperty
	private int cantidad;
	
	@ManyToOne
	@JoinColumn(name = "pro_id")
	@JsonbProperty
	private Producto productos;
	
	@ManyToOne
	@JoinColumn(name = "num_cabecera")
	@JsonbProperty
	private Pedido_Cabecera pedidoCab;

	public Pedido_Detalle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pedido_Detalle(int num_detalle, int cantidad, Producto productos, Pedido_Cabecera pedidoCab) {
		super();
		this.num_detalle = num_detalle;
		this.cantidad = cantidad;
		this.productos = productos;
		this.pedidoCab = pedidoCab;
	}

	public int getNum_detalle() {
		return num_detalle;
	}

	public void setNum_detalle(int num_detalle) {
		this.num_detalle = num_detalle;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Producto getProductos() {
		return productos;
	}

	public void setProductos(Producto productos) {
		this.productos = productos;
	}

	public Pedido_Cabecera getPedidoCab() {
		return pedidoCab;
	}

	public void setPedidoCab(Pedido_Cabecera pedidoCab) {
		this.pedidoCab = pedidoCab;
	}
	
	
}
