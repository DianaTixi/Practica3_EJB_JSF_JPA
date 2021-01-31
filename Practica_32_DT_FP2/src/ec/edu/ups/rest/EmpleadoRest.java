package ec.edu.ups.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ec.edu.ups.ejb.EmpleadoFacade;
import ec.edu.ups.entidad.Empleados;

@Path("/empleado/")
public class EmpleadoRest {
	
	@EJB
	private EmpleadoFacade ejbEmpleadoFacade;
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getIdEmp(@PathParam("id") Integer id) {
		System.out.println("ENtra a api call");
		System.out.println("Id del api="+id);
		Jsonb jsonb = JsonbBuilder.create();
		Empleados empleado = ejbEmpleadoFacade.findEmp(id);
		
		return Response.ok(jsonb.toJson(empleado)).build();
	}
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllEmp() {
		System.out.println("ENtra a api call");
		
		Jsonb jsonb = JsonbBuilder.create();
		List<Empleados> empleados = ejbEmpleadoFacade.findAll();
		
		return Response.ok(jsonb.toJson(empleados)).build();
	}
	

}
