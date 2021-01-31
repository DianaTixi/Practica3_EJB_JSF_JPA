package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.CategoriaFacade;

import ec.edu.ups.entidad.Categoria;
import ec.edu.ups.entidad.Ciudad;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class CategoriaBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EJB
    private CategoriaFacade ejbCategoriaFacade;
    
    private List<Categoria> lista;
    private Categoria categoria;
    private String nombre;
    private String descripcion;
    
    
	public CategoriaBean() {
		
	}
	
	@PostConstruct
    public void init() {
		lista = ejbCategoriaFacade.findAll();
	
    }
	
	public Categoria[] getLista() {
		return lista.toArray(new Categoria[0]);
	}
	public void setLista(List<Categoria> lista) {
		this.lista = lista;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String add() {
		ejbCategoriaFacade.create(new Categoria(0,this.nombre,this.descripcion));
		return null;
	}
	
	public String listarCategorias() {
		lista = ejbCategoriaFacade.findAll();
		return null;
	}
    
    
}
