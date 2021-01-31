package ec.edu.ups.ejb;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entidad.Categoria;

@Stateless
public class CategoryFacade extends AbstractFacade<Categoria> {

    @PersistenceContext(unitName = "Prueba")
    private EntityManager em;

    public CategoryFacade() {
        super(Categoria.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}

