package ec.edu.ups.entidad;

import java.io.Serializable;
import java.util.ArrayList;

import javax.json.bind.annotation.JsonbProperty;
import javax.persistence.*;

@Entity
public class FacturaCabecera implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonbProperty
	private int numeroP;
	@JsonbProperty
	private String fecha;
	@JsonbProperty
	private Double subtotal;
	@JsonbProperty
	private Double iva;
	@JsonbProperty
	private Double total;
	@JsonbProperty
	private char estado;
	
	@ManyToOne
	@JoinColumn(name = "emp_id",  nullable = false)
	@JsonbProperty
	private Empleados empleado ;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "facturaCab")
	@JsonbProperty
	private ArrayList<FacturaDetalle> facturaDet;

	public FacturaCabecera() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public FacturaCabecera(int numeroP, String fecha, Double subtotal, Double iva, Double total, char estado,
			Empleados empleado) {
		super();
		this.numeroP = numeroP;
		this.fecha = fecha;
		this.subtotal = subtotal;
		this.iva = iva;
		this.total = total;
		this.estado = estado;
		this.empleado = empleado;
	}




	public int getNumeroP() {
		return numeroP;
	}

	public void setNumeroP(int numeroP) {
		this.numeroP = numeroP;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	public Double getIva() {
		return iva;
	}

	public void setIva(Double iva) {
		this.iva = iva;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
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

	public ArrayList<FacturaDetalle> getFacturaDet() {
		return facturaDet;
	}

	public void setFacturaDet(ArrayList<FacturaDetalle> facturaDet) {
		this.facturaDet = facturaDet;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	} 
	
	
}
