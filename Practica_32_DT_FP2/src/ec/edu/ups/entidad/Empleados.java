package ec.edu.ups.entidad;

import java.io.Serializable;
import java.util.ArrayList;

import javax.json.bind.annotation.JsonbProperty;
import javax.persistence.*;

@Entity
public class Empleados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
    @JsonbProperty
	private int id;
    @JsonbProperty
	private String cedula;
    @JsonbProperty
	private String nombre;
    @JsonbProperty
	private String apellido;
    @JsonbProperty
	private char rol;
    @JsonbProperty
	private String telefono;
    @JsonbProperty
	private String direccion;
    @JsonbProperty
	private String email;
    @JsonbProperty
	private String password;
    @JsonbProperty
	private char estado;
	
    @JsonbProperty
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado")
	private ArrayList<Pedido_Cabecera> pedidos;
	
	@JsonbProperty
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado")
	private ArrayList<FacturaCabecera> facturas;
	
	public Empleados() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Empleados(int id, String cedula, String nombre, String apellido, char rol, String telefono, String direccion,
			char estado, String email, String password) {
		super();
		this.id = id;
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.rol = rol;
		this.telefono = telefono;
		this.direccion = direccion;
		this.estado= estado;
		this.email = email;
		this.password = password;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public char getRol() {
		return rol;
	}
	public void setRol(char rol) {
		this.rol = rol;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public char getEstado() {
		return estado;
	}

	public void setEstado(char estado) {
		this.estado = estado;
	}

	public ArrayList<Pedido_Cabecera> getPedidos() {
		return pedidos;
	}

	public void setPedidos(ArrayList<Pedido_Cabecera> pedidos) {
		this.pedidos = pedidos;
	}

	public ArrayList<FacturaCabecera> getFacturas() {
		return facturas;
	}

	public void setFacturas(ArrayList<FacturaCabecera> facturas) {
		this.facturas = facturas;
	}
	
	
	

}
