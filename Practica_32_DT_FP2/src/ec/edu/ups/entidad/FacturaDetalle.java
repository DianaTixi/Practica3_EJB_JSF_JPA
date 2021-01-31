package ec.edu.ups.entidad;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class FacturaDetalle  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int cantidad;
	private Double precioU;
	private Double subtotal;
	
	@ManyToOne
	@JoinColumn(name = "pro_id")
	private Producto productos;
	
	@ManyToOne
	@JoinColumn(name = "numeroP")
	private FacturaCabecera facturaCab;

	public FacturaDetalle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FacturaDetalle(int id, int cantidad, Double precioU, Double subtotal, Producto productos,
			FacturaCabecera facturaCab) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.precioU = precioU;
		this.subtotal = subtotal;
		this.productos = productos;
		this.facturaCab = facturaCab;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Double getPrecioU() {
		return precioU;
	}

	public void setPrecioU(Double precioU) {
		this.precioU = precioU;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	public Producto getProductos() {
		return productos;
	}

	public void setProductos(Producto productos) {
		this.productos = productos;
	}

	public FacturaCabecera getFacturaCab() {
		return facturaCab;
	}

	public void setFacturaCab(FacturaCabecera facturaCab) {
		this.facturaCab = facturaCab;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
