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
import ec.edu.ups.ejb.FacturaDetalleFacade;
import ec.edu.ups.entidad.Empleados;
import ec.edu.ups.entidad.FacturaCabecera;
import ec.edu.ups.entidad.FacturaDetalle;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class FacturaDetalleBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	@EJB
	private FacturaDetalleFacade ejbFacturaDetalle;
	
	private List<FacturaDetalle> listaDetalles;
	
	private int numeroP;
	private String fecha;
	private Double subtotal;
	private Double iva;
	private Double total;
	private char estado;
	
	private List<Empleados> listaempleado;
	
	public FacturaDetalleBean() {
		
	}
	
	@PostConstruct
	public void init() {
	
		
	}

	
	
	

}
