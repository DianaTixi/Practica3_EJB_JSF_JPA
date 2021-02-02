package ec.edu.ups.entidad;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;

@Entity
public class BodegaProducto implements  Serializable {

    private static final long serialVersionUID = 1L;
    
    @JsonbProperty
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int stock;
    
    @JsonbTransient
    @ManyToOne 
    @JoinColumn(name = "bod_id", nullable = false)
    private Bodega bodega;
    
    @JsonbTransient
    @ManyToOne
    @JoinColumn(name = "pro_id", nullable = false)
    private Producto producto;

	public BodegaProducto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BodegaProducto(int id,int stock, Bodega bodega, Producto producto) {
		super();
		this.id = id;
		this.stock= stock;
		this.bodega = bodega;
		this.producto = producto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Bodega getBodega() {
		return bodega;
	}

	public void setBodega(Bodega bodega) {
		this.bodega = bodega;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
    
    
}
