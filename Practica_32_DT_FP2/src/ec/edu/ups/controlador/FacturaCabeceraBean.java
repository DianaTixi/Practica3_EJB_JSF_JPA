package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.FacturaCabeceraFacade;
import ec.edu.ups.entidad.Empleados;
import ec.edu.ups.entidad.FacturaCabecera;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class FacturaCabeceraBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	@EJB
	private FacturaCabeceraFacade ejbFacturaCabecera;
	
	private List<FacturaCabecera> lisafacturas;
	
	private int numeroP;
	private String fecha;
	private Double subtotal;
	private Double iva;
	private Double total;
	private char estado;
	
	private List<Empleados> listaempleado;
	
	public FacturaCabeceraBean() {
		
	}
	
	@PostConstruct
	public void init() {
		
		listaempleado = new ArrayList<Empleados>();
		
		lisafacturas = new ArrayList<FacturaCabecera>();
		lisafacturas = ejbFacturaCabecera.findAll();
		
	}

	public List<Empleados> getListaempleado() {
		return listaempleado;
	}

	public void setListaempleado(List<Empleados> listaempleado) {
		this.listaempleado = listaempleado;
	}

	public FacturaCabeceraFacade getEjbFacturaCabecera() {
		return ejbFacturaCabecera;
	}

	public void setEjbFacturaCabecera(FacturaCabeceraFacade ejbFacturaCabecera) {
		this.ejbFacturaCabecera = ejbFacturaCabecera;
	}

	public FacturaCabecera[] getLisafacturas() {
		return lisafacturas.toArray(new FacturaCabecera[0]);
	}

	public void setLisafacturas(List<FacturaCabecera> lisafacturas) {
		this.lisafacturas = lisafacturas;
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
	
	public String delete() {
		FacturaCabecera f = ejbFacturaCabecera.buscarF(this.numeroP);
	
		f.setEstado('E');
		ejbFacturaCabecera.edit(f);
		
		return null;
	}
	
	

}
