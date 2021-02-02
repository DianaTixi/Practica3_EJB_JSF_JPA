package ec.edu.ups.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ec.edu.ups.ejb.EmpleadoFacade;
import ec.edu.ups.ejb.PedidoCabeceraFacade;
import ec.edu.ups.ejb.PedidoDetalleFacade;
import ec.edu.ups.ejb.ProductoFacade;
import ec.edu.ups.entidad.Empleados;
import ec.edu.ups.entidad.Pedido_Cabecera;
import ec.edu.ups.entidad.Pedido_Detalle;
import ec.edu.ups.entidad.Producto;

@Path("/pedido/")
public class PedidoRest {

	@EJB
	private PedidoCabeceraFacade ejbPedCab;
	
	@EJB
	private PedidoDetalleFacade ejbPedDet;
	
	@EJB
	private EmpleadoFacade ejbEmpleado;
	
	@EJB
    private ProductoFacade ejbProductoFacade;
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getIdPed(@PathParam("id") Integer id) {
		System.out.println("ENtra a api call");
		System.out.println("Id del api="+id);
		Jsonb jsonb = JsonbBuilder.create();
		Empleados emp = new Empleados();
		emp = ejbEmpleado.findEmp(id);
		
		List<Pedido_Cabecera> list = new ArrayList<>();
		list.clear();
		List<Pedido_Cabecera> aux_lost = new ArrayList<Pedido_Cabecera>();
		aux_lost.clear();
		
		list = ejbPedCab.findAll();
		
		
		for (int i = 0; i < list.size(); i++) {
		
			if (list.get(i).getEmpleado().getId()==id) {
				aux_lost.add(list.get(i));
			}
		}
		
		return Response.ok(jsonb.toJson(aux_lost)).build();
	}
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllPed() {
		System.out.println("ENtra a api call");
		
		Jsonb jsonb = JsonbBuilder.create();
		List<Pedido_Cabecera> ped = ejbPedCab.findAll();

		return Response.ok(jsonb.toJson(ped)).build();
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public Response postPed(@FormParam("estado") String estado, @FormParam("emp_id") int emp_id) throws IOException{
		Pedido_Cabecera ped = new Pedido_Cabecera();
		//Pedido_Detalle det = new Pedido_Detalle();
		Empleados emp = ejbEmpleado.find(emp_id);
		
		ped.setEstado(estado.charAt(0));
		ped.setEmpleado(emp);
		
		
		try {
			ejbPedCab.create(ped);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al crear pedido");
			return Response.status(500).build();
		}
		
		
		return Response.status(201).entity("Pedido creado correctamente: "+ped).build();
	}
	
	@PUT
	@Path("/edit")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response editPed(String jsonPed) {
		
		Jsonb jsonb = JsonbBuilder.create();
		Pedido_Cabecera ped = jsonb.fromJson(jsonPed, Pedido_Cabecera.class);
		
		//System.out.println(emp.getApellido());
		try {
			ejbPedCab.edit(ped);
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
		
	
		return Response.status(200).entity("Pedido actualizado: " + ped).build();
	}
	
	
	@POST
	@Path("/bodcat")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getbodcat(@FormParam("bodega") String bodega, @FormParam("categoria") String categoria) throws IOException{
		
		Jsonb jsonb = JsonbBuilder.create();
		List<Producto> list = ejbProductoFacade.ListarPro_Bod_Cat(bodega, categoria);
		
		return Response.ok(jsonb.toJson(list)).build();
	}
	
}
