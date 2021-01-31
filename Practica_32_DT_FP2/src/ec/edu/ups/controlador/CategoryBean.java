package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.CategoryFacade;
import ec.edu.ups.entidad.Categoria;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class CategoryBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private CategoryFacade ejbCategoryFacade;
    
    private List<Categoria> list;
    private String descripcion;

    public CategoryBean() {

    }    
    
    @PostConstruct
    public void init() {
	//ejbCategoryFacade.create(new Category("Hola"));
	//ejbCategoryFacade.create(new Category("1211"));
	list = ejbCategoryFacade.findAll();
    }
        
    public Categoria[] getList() {
	return list.toArray(new Categoria[0]);
    }

    public void setList(List<Categoria> list) {
	this.list = list;
    }

    public String getDescripcion() {
	return descripcion;
    }

    public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
    }

    public String add() {
	ejbCategoryFacade.create(new Categoria(this.descripcion));
	list = ejbCategoryFacade.findAll();
	return null;
    }

    public String delete(Categoria c) {	
	ejbCategoryFacade.remove(c);
	list = ejbCategoryFacade.findAll();
	return null;
    }


}