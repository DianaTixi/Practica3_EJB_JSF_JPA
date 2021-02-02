package ec.edu.ups.rest;

import java.io.IOException;
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
import ec.edu.ups.entidad.Empleados;



@Path("/empleado/")
public class EmpleadoRest {
	
	@EJB
	private EmpleadoFacade ejbEmpleadoFacade;
	
	private Empleados empleados;
	
	@POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public Response login(@FormParam("correo") String correo, @FormParam("contraseña") String contrasena) throws IOException {
		Empleados empleado = new Empleados();
		empleado = ejbEmpleadoFacade.buscarEmp(correo, contrasena);
		
		if(empleado != null) {
			System.out.println("usuario encontrado");
			return Response.ok("Inicio de Sesion Correcto").build();
			
		}else {
			return Response.status(404).entity("Usuario no encontrado").build();
			
		}
		
    }
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getIdEmp(@PathParam("id") Integer id) {
		System.out.println("ENtra a api call");
		System.out.println("Id del api="+id);
		Jsonb jsonb = JsonbBuilder.create();
		Empleados empleado = new Empleados();
		try {
			empleado = ejbEmpleadoFacade.findEmp(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
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
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public Response postEmp(@FormParam("nombre") String nombre, @FormParam("apellido") String apellido, @FormParam("cedula") String cedula,
			@FormParam("direccion") String direccion, @FormParam("email") String email,@FormParam("telefono") String telefono ,
			@FormParam("estado") String estado, @FormParam("password") String password, @FormParam("rol") String rol) throws IOException{
		Empleados emp = new Empleados();
		emp.setNombre(nombre);
		emp.setApellido(apellido);
		emp.setCedula(cedula);
		emp.setDireccion(direccion);
		emp.setEmail(email);
		emp.setTelefono(telefono);
		emp.setEstado(estado.charAt(0));
		emp.setPassword(password);
		emp.setRol(rol.charAt(0));
		try {
			ejbEmpleadoFacade.create(emp);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al crear empleado");
			return Response.status(500).build();
		}
		
		
		return Response.status(201).entity("Empleado creado correctamente: "+emp).build();
	}
	
	@PUT
	@Path("/edit")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response editEmp(String jsonEmp) {
		
		Jsonb jsonb = JsonbBuilder.create();
		Empleados emp = jsonb.fromJson(jsonEmp, Empleados.class);
		
		System.out.println(emp.getApellido());
		try {
			ejbEmpleadoFacade.edit(emp);
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
		
	
		return Response.status(200).entity("Empleado actualizado: " + emp).build();
	}

	@PUT
    @Path("/anular")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public Response anular(@FormParam("cedula") String cedula){
		
		Empleados empleado = new Empleados();
        empleado = ejbEmpleadoFacade.buscarEmp(cedula);
        if(empleado != null){
            try{
            	empleado = new Empleados();
            	empleado = ejbEmpleadoFacade.buscarEmp(cedula);
            	empleado.setEstado('I');
                return Response.ok("Inactivo").build();
                
            }catch (Exception e){
               e.printStackTrace();
               return Response.status(500).build();
            }
        }else{
        	return  Response.status(200).entity("Cliente Inactivo: " + empleado).build();
        }
		
    }	
	

}
