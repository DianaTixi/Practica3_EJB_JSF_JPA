package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.CiudadFacade;
import ec.edu.ups.entidad.Ciudad;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class CiudadBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private CiudadFacade ejbCiudadFacade;
    
    private List<Ciudad> lista;
    private String nombre;
    
    
	public CiudadBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
    @PostConstruct
    public void init() {
    	lista = ejbCiudadFacade.findAll();
    	
    }
    
    public Ciudad[] getList() {
    	return lista.toArray(new Ciudad[0]);
    }

	public void setLista(List<Ciudad> lista) {
		this.lista = lista;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String  add() {
		ejbCiudadFacade.create(new Ciudad(0,this.nombre));
		lista = ejbCiudadFacade.findAll();
		return null;
		
	}
    
    
    

}
