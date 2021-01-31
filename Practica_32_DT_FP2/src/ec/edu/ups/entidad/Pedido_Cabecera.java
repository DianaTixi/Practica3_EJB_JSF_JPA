package ec.edu.ups.entidad;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Pedido_Cabecera implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int num_cabecera;
	private char estado;
	
	@ManyToOne
	@JoinColumn(name = "emp_id",  nullable = false)
	private Empleados empleado ;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pedidoCab")
	private ArrayList<Pedido_Detalle> pedidoDet;

	public Pedido_Cabecera() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Pedido_Cabecera(int num_cabecera, char estado, Empleados empleado) {
		super();
		this.num_cabecera = num_cabecera;
		this.estado = estado;
		this.empleado = empleado;
	}

	public int getNum_cabecera() {
		return num_cabecera;
	}

	public void setNum_cabecera(int num_cabecera) {
		this.num_cabecera = num_cabecera;
	}

	public char getEstado() {
		return estado;
	}

	public void setEstado(char estado) {
		this.estado = estado;
	}

	public Empleados getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleados empleado) {
		this.empleado = empleado;
	}

	public ArrayList<Pedido_Detalle> getPedidoDet() {
		return pedidoDet;
	}

	public void setPedidoDet(ArrayList<Pedido_Detalle> pedidoDet) {
		this.pedidoDet = pedidoDet;
	}
	
	
}
