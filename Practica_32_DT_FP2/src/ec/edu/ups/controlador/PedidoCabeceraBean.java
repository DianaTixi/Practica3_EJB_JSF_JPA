package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.PedidoCabeceraFacade;
import ec.edu.ups.ejb.PedidoDetalleFacade;
import ec.edu.ups.entidad.Empleados;
import ec.edu.ups.entidad.Pedido_Detalle;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class PedidoCabeceraBean implements Serializable{

	 private static final long serialVersionUID = 1L;
	
	 @EJB
	 private PedidoCabeceraFacade ejbPedCabFacade;
	 
	 @EJB
	 private PedidoDetalleFacade ejbPedDetFacade;
	 
	 private List<Pedido_Detalle> listPedDet;
	 
	 private int num_cabecera;
	 private char estado;
	 
	 private Empleados empleado;
	 
	 
	 
	 @PostConstruct
	 public void init() {
		 listPedDet = new ArrayList<Pedido_Detalle>();
	 }



	public PedidoCabeceraFacade getEjbPedCabFacade() {
		return ejbPedCabFacade;
	}



	public void setEjbPedCabFacade(PedidoCabeceraFacade ejbPedCabFacade) {
		this.ejbPedCabFacade = ejbPedCabFacade;
	}



	public PedidoDetalleFacade getEjbPedDetFacade() {
		return ejbPedDetFacade;
	}



	public void setEjbPedDetFacade(PedidoDetalleFacade ejbPedDetFacade) {
		this.ejbPedDetFacade = ejbPedDetFacade;
	}



	public List<Pedido_Detalle> getListPedDet() {
		return listPedDet;
	}



	public void setListPedDet(List<Pedido_Detalle> listPedDet) {
		this.listPedDet = listPedDet;
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
	 
	 
	 
}
