package ec.edu.ups.entidad;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.*;

@Entity
public class Bodega implements  Serializable { 

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String direccion; 
    
    @ManyToOne
	@JoinColumn(name = "cd_id", nullable = false)
	private Ciudad ciudad;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bodega")
    private ArrayList<BodegaProducto> bodega_producto;
    
	public Bodega() {
		super();
	}

	public Bodega(int id, String direccion, String nombre, Ciudad ciudad) {
		super();
		this.id = id;
		this.direccion = direccion;
		this.nombre = nombre;
		this.ciudad = ciudad;
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public ArrayList<BodegaProducto> getBodega_producto() {
		return bodega_producto;
	}

	public void setBodega_producto(ArrayList<BodegaProducto> bodega_producto) {
		this.bodega_producto = bodega_producto;
	}
   
}

