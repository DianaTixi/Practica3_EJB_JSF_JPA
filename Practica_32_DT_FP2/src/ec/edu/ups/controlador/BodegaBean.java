package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Default;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;
import javax.ws.rs.DefaultValue;

import ec.edu.ups.ejb.BodegaFacade;
import ec.edu.ups.ejb.CiudadFacade;
import ec.edu.ups.entidad.Bodega;
import ec.edu.ups.entidad.Categoria;
import ec.edu.ups.entidad.Ciudad;
import ec.edu.ups.entidad.Producto;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class BodegaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private BodegaFacade ejbBodegaFacade;
    
    @EJB
    private CiudadFacade ejbCiudadFacade;
    
    
    private List<Bodega> lista;
    private Bodega bodega;
    
    private Ciudad ciudad;
    private List<Ciudad> listaCiudad;
    
    private List<Producto>listaProductos;  
    private Producto producto;
    
    private List<Bodega> listaBuscar;
    private String nombre;
    private String nombre1;
    private String direccion;
    private String nombreCuidad;
    private int idCiudad;
    
    
    
	public BodegaBean() {
		
	}
	
	@PostConstruct
    public void init() {
		lista = new ArrayList<Bodega>();
		listaCiudad = new ArrayList<Ciudad>();
		listaBuscar = new ArrayList<Bodega>();
		lista = ejbBodegaFacade.findAll();
	
    }

	public Bodega[] getList() {
		return lista.toArray(new Bodega[0]);
	}

	public void setLista(List<Bodega> lista) {
		this.lista = lista;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

	public String getNombre1() {
		return nombre1;
	}

	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getIdCiudad() {
		return idCiudad;
	}

	public void setIdCiudad(int idCiudad) {
		this.idCiudad = idCiudad;
	}

	public List<Bodega> getLista() {
		return lista;
	}

	
	public String getNombreCuidad() {
		return nombreCuidad;
	}

	public void setNombreCuidad(String nombreCuidad) {
		this.nombreCuidad = nombreCuidad;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}
	
	
	public List<Bodega> getListaBuscar() {
		return listaBuscar;
	}

	public void setListaBuscar(List<Bodega> listaBuscar) {
		this.listaBuscar = listaBuscar;
	}

	public String add() {
		System.out.println("Nombre: "+this.nombre);
		try {
			
			Ciudad ciudad= ejbCiudadFacade.buscarNombre(this.nombreCuidad);
			System.out.println("El nombre de la ciudad es: "+ciudad.getNombre() + " Id: "+ciudad.getId());
			ejbBodegaFacade.create(new Bodega(0, this.direccion, this.nombre,ciudad));	
			lista = ejbBodegaFacade.findAll();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "GestionBodega.xhtml";
	}
	
	public String delete() {
		Bodega bodega = ejbBodegaFacade.buscarBodega(this.nombre);
		System.out.println("Nombre de la Bodega: "+bodega.getNombre());
		ejbBodegaFacade.remove(bodega);
		
		return "GestionBodega.xhtml";
	    }
	
	public String buscar() {
		System.out.println("El nombre de la bodega es: "+ this.nombre);
		Bodega bodega = ejbBodegaFacade.buscarBodega(this.nombre);
		listaBuscar=ejbBodegaFacade.BuscarBodega(this.nombre);
		
		return null;
		
	}
	public String edit()  {
		Bodega bodega = ejbBodegaFacade.buscarBodega(nombre);
		Ciudad ciudad= ejbCiudadFacade.buscarNombre(this.nombreCuidad);
		
		bodega.setNombre(this.nombre1);
		bodega.setDireccion(this.direccion);
		bodega.setCiudad(ciudad);
		ejbBodegaFacade.edit(bodega);
		lista = ejbBodegaFacade.findAll();
		return "GestionBodega.xhtml";
	}
	
	public List<Bodega> listarBodegas(){
		lista = ejbBodegaFacade.findAll();
		System.out.println("Tamaño lista de bodegas: "+lista.size());
		return lista;
	}
	
	
	
}
