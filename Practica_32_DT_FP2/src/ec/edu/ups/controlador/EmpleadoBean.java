package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.EmpleadoFacade;
import ec.edu.ups.entidad.Empleados;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class EmpleadoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private EmpleadoFacade ejEmpleadoFacade;
    
    private List<Empleados> lista;
    private Empleados empleados;
    
    private List<Empleados> listaBuscar;
    
    private String nombre;
    private String apellido;
    private String cedula;
    private String telefono;
    private String direccion;
    private String pass1;
    private String email1;
    private String estadoCliente;
    private String pass;
    private String email;
    private char rol;
    private char estado;
 
    private String cedula1;
    private String cedulaCliente;
    
    private Empleados empleado;
    
	public EmpleadoBean() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	@PostConstruct
    public void init() {
		empleados = new Empleados();
		lista = new ArrayList<Empleados>();
		
		listaBuscar= ejEmpleadoFacade.buscarC('A','C');
	}

	public Empleados[] getLista() {
		return lista.toArray(new Empleados[0]);
	}

	public void setLista(List<Empleados> lista) {
		this.lista = lista;
	}
	

	public List<Empleados> getListaBuscar() {
		return listaBuscar;
	}

	public void setListaBuscar(List<Empleados> listaBuscar) {
		this.listaBuscar = listaBuscar;
	}

	public String getEstadoCliente() {
		return estadoCliente;
	}

	public void setEstadoCliente(String estadoCliente) {
		this.estadoCliente = estadoCliente;
	}

	public String getCedula1() {
		return cedula1;
	}

	public void setCedula1(String cedula1) {
		this.cedula1 = cedula1;
	}

	public String getCedulaCliente() {
		return cedulaCliente;
	}

	public void setCedulaCliente(String cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
	
	public EmpleadoFacade getEjEmpleadoFacade() {
		return ejEmpleadoFacade;
	}

	public void setEjEmpleadoFacade(EmpleadoFacade ejEmpleadoFacade) {
		this.ejEmpleadoFacade = ejEmpleadoFacade;
	}

	public Empleados getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleados empleado) {
		this.empleado = empleado;
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

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
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
	

	public String getPass1() {
		return pass1;
	}

	public void setPass1(String pass1) {
		this.pass1 = pass1;
	}

	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public char getRol() {
		return rol;
	}

	public void setRol(char rol) {
		this.rol = rol;
	}

	public char getEstado() {
		return estado;
	}

	public void setEstado(char estado) {
		this.estado = estado;
	}

	public String IniciarSesion() {
			String url =null;
			Empleados empleados= ejEmpleadoFacade.buscarEmp(email, pass);
			System.out.println("Nombre :" + empleados.getNombre()+ " Rol: "+ empleados.getRol());
			empleado = empleados;
			char rol = empleados.getRol();
			if (rol == 'A') {
				url= "/private/admin/Admin.xhtml";
			}else {
				if (rol == 'E') {
					url = "/private/emp/Empleado.xhtml";
				}else {
					if (rol == 'C') {
						url= "/private/user/Cliente.xhtml";
					}else {
						url="/public/IniciarSesion.xhtml";
					}
				}
			}
			return url;
	}
	
	public String add() {
		System.out.println("Nombre: "+ this.nombre+" Cedula:"+this.cedula);
		rol = 'C';
		estado = 'A';
		try {
			Empleados emp = new Empleados();
			emp.setId(0);
			emp.setNombre(this.nombre);
			emp.setApellido(this.apellido);
			emp.setCedula(this.cedula);
			emp.setDireccion(this.direccion);
			emp.setTelefono(this.telefono);
			emp.setEmail(this.email1);
			emp.setPassword(this.pass1);
			emp.setRol(rol);
			emp.setEstado(estado);
			ejEmpleadoFacade.create(emp);
			lista = ejEmpleadoFacade.findAll();
			emp = new Empleados();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error");
			
		}
		return "Empleado.xhtml";
	}
	
	public String listarC() {
		char cliente= 'C';
		lista=ejEmpleadoFacade.listaClientes(cliente);
		return "listarClientes.xhtml";
	}
	
	public String buscarCliente() {
		System.out.println("La cedula ingresada es: "+this.cedulaCliente);
		lista= ejEmpleadoFacade.buscarCli(cedulaCliente);
		return null;
	}
	
	public String editar() {
		System.out.println("La cedula a buscar es: "+ this.cedula1);
		Empleados empleado = new Empleados();
		empleado = ejEmpleadoFacade.buscarEmp(cedula1);
		
		char estado1 ='I';
		empleado.setEstado(estado1);
		ejEmpleadoFacade.edit(empleado);
		return "listarClientes.xhtml";
	}
	
	public String modificar() {
		Empleados empleado = new Empleados();
		empleado = ejEmpleadoFacade.buscarEmp(this.cedulaCliente);
		System.out.println("La cedula del cliente es: "+this.cedulaCliente);
		System.out.println("|"+nombre+"|"+"|"+apellido+"|"+"|"+cedula+"|"+"|"+email1+"|"+"|"+direccion+"|"+"|"+telefono+"|");
		
		empleado.setNombre(nombre);
		empleado.setApellido(apellido);
		empleado.setCedula(cedula);
		empleado.setDireccion(direccion);
		empleado.setEmail(email1);
		empleado.setTelefono(telefono);
		ejEmpleadoFacade.edit(empleado);
		empleado = new Empleados();
		return "Empleado.xhtml";
	}
	
	public String editEmple() {
		ejEmpleadoFacade.edit(empleado);
		return "Cliente.xhtml";
	}

}
