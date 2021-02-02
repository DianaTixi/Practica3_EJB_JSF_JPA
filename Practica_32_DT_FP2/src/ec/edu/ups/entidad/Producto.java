package ec.edu.ups.entidad;

import java.io.Serializable;
import java.util.ArrayList;

import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Producto
 *
 */
@Entity
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @JsonbProperty
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private String descripcion;
	private double precio;
	//private String pro_imagen;
	
	@JsonbProperty
	@ManyToOne
	@JoinColumn(name = "cat_id", nullable = false)
	private Categoria categoria;
	
	@JsonbTransient
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "productos" )
	private ArrayList<FacturaDetalle> facturaDet; 

	@JsonbTransient
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "productos" )
	private ArrayList<Pedido_Detalle> pedidoDet; 

	@JsonbTransient
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "producto")
	private ArrayList<BodegaProducto> bodega_producto;
	
	public Producto() {

	}


	public Producto(int id, String descripcion, String nombre, double precio,  Categoria categoria) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.nombre = nombre;
		this.precio = precio;
		this.categoria = categoria;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public ArrayList<FacturaDetalle> getFacturaDet() {
		return facturaDet;
	}

	public void setFacturaDet(ArrayList<FacturaDetalle> facturaDet) {
		this.facturaDet = facturaDet;
	}

	public ArrayList<BodegaProducto> getBodega_producto() {
		return bodega_producto;
	}

	public void setBodega_producto(ArrayList<BodegaProducto> bodega_producto) {
		this.bodega_producto = bodega_producto;
	}


	public ArrayList<Pedido_Detalle> getPedidoDet() {
		return pedidoDet;
	}


	public void setPedidoDet(ArrayList<Pedido_Detalle> pedidoDet) {
		this.pedidoDet = pedidoDet;
	}
    
	

}
