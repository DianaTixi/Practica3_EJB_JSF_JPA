package ec.edu.ups.controlador;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.FacturaCabeceraFacade;
import ec.edu.ups.ejb.FacturaDetalleFacade;
import ec.edu.ups.ejb.PedidoCabeceraFacade;
import ec.edu.ups.ejb.PedidoDetalleFacade;
import ec.edu.ups.entidad.Categoria;
import ec.edu.ups.entidad.Empleados;
import ec.edu.ups.entidad.FacturaCabecera;
import ec.edu.ups.entidad.FacturaDetalle;
import ec.edu.ups.entidad.Pedido_Cabecera;
import ec.edu.ups.entidad.Pedido_Detalle;
import ec.edu.ups.entidad.Producto;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class PedidoCabeceraBean implements Serializable{

	 private static final long serialVersionUID = 1L;
	
	 @EJB
	 private PedidoCabeceraFacade ejbPedCabFacade;
	 
	 @EJB
	 private PedidoDetalleFacade ejbPedDetFacade;
	 
	 @EJB
	 private FacturaCabeceraFacade ejCabeceraFacade;
	 
	@EJB
	private FacturaDetalleFacade ejDetalleFacade;
	
	 
	 private List<Pedido_Detalle> listPedDet;
	 private List<Pedido_Cabecera> pedidos;
	 private List<Producto> listaProductos;
	 private ArrayList<FacturaDetalle> Fdetalle;
	 
	 private FacturaCabecera factura;
	 private FacturaDetalle detalle;
	 private int num_cabecera;
	 private char estado;
	 private Empleados empleado;
	 
	 
	 
	 @PostConstruct
	 public void init() {
		 listPedDet = new ArrayList<Pedido_Detalle>();
		 pedidos = new ArrayList<Pedido_Cabecera>();
		 listaProductos = new ArrayList<Producto>();
		 pedidos= ejbPedCabFacade.findAll();
		 Fdetalle= new ArrayList<FacturaDetalle>();
	 }

	public Pedido_Cabecera[] getPedidos() {
		return pedidos.toArray(new Pedido_Cabecera[0]);
	}
	public void setPedidos(List<Pedido_Cabecera> pedidos) {
		this.pedidos = pedidos;
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
	
	public String cambiarEstado(int num_cabecera) {
		// Cambiar Estado del Pedido
		char estado = 'R';
		System.out.println("Id del Pedido" + num_cabecera);
		Pedido_Cabecera pedidoC = new Pedido_Cabecera();
		pedidoC = ejbPedCabFacade.buscar(num_cabecera);
		pedidoC.setEstado(estado);
		ejbPedCabFacade.edit(pedidoC);
		
		//
		ArrayList<Pedido_Detalle>listaDetalles= new ArrayList<Pedido_Detalle>();
		
		//Lista Pedidos Cabecera
		pedidos= ejbPedCabFacade.findAll();
		//Lista Pedidos Detalle
		listPedDet= ejbPedDetFacade.findAll();
		
		
		for (int i = 0; i < listPedDet.size(); i++) {
			if (listPedDet.get(i).getPedidoCab().getNum_cabecera()==num_cabecera) {
				listaDetalles.add(listPedDet.get(i));
			}
		}
		
		double subtotal = 0.0;
		for (int i = 0; i < listaDetalles.size(); i++) {
			try {
				// Obtengo la cantidad del producto
				int cantidad = listaDetalles.get(i).getCantidad();
				
				//Obtengo el objeto producto 
				Producto producto = listaDetalles.get(i).getProductos();
				
				// Creamos la factura detalle
				FacturaDetalle detalle = new FacturaDetalle();
				detalle.setCantidad(cantidad);
				detalle.setProductos(producto);
				detalle.setPrecioU(producto.getPrecio());
				detalle.setSubtotal(cantidad*producto.getPrecio());	
				subtotal=subtotal+(cantidad * producto.getPrecio());
				Fdetalle.add(detalle);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//Obtenemos el Cliente de pedido cabecera 
		int idCliente=0;
		empleado = new Empleados();
		if (pedidos.size()> 0) {
			empleado = pedidos.get(0).getEmpleado();
		}
		
		//Creacion Factura Cabecera
				FacturaCabecera factura = new FacturaCabecera();
				double iva=1.2;
				// Crear factura 
				factura.setEstado('A');
				Date fecha = new Date();
				String pattern = "YYYY-MM-dd HH:mm:ss";
				SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		        String mysqlDateString = formatter.format(fecha);
				factura.setFecha(mysqlDateString);
				factura.setIva(1.12);
				factura.setSubtotal(subtotal);
				factura.setTotal(subtotal*iva);
				factura.setEmpleado(empleado);
				ejCabeceraFacade.create(factura);
				
				List<FacturaCabecera> factuAux = new ArrayList<FacturaCabecera>();
				factuAux = ejCabeceraFacade.findAll();
				
				FacturaCabecera fac = factuAux.get(factuAux.size()-1);
				
				//Asignamos el pedido cabecera 
				for (int i = 0; i < Fdetalle.size(); i++) {
					Fdetalle.get(i).setFacturaCab(fac);
					ejDetalleFacade.create(Fdetalle.get(i));
				}
		
		return  "Admin.xhtml";
	}
	 
	 
	 
}

