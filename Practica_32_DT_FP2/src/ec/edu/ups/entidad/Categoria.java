package ec.edu.ups.entidad;

import java.io.Serializable;
import java.util.List;

import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Categoria
 *
 */
@Entity
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @JsonbProperty
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JsonbProperty
    @Column  
    private String nombre;
    @JsonbProperty
    @Column
    private String descripcion;
    
    @JsonbTransient
    @OneToMany(mappedBy = "categoria")
    private List<Producto> productos;

    public Categoria() {

    }
    
    public Categoria(int id, String nombre, String descripcion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}


	public int getId() {
	return id ;
    }

    public void setId(int id ) {
	this.id  = id ;
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
	
	public Categoria(String descripcion) {
		this.descripcion = descripcion;
    }
	
    public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
    }

    public List<Producto> getProductos() {
	return productos;
    }

    public void setProductos(List<Producto> productos) {
	this.productos = productos;
    
    }
}
