package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entidad.Categoria;

@Stateless
public class CategoriaFacade extends AbstractFacade<Categoria>{
	@PersistenceContext(unitName = "Prueba")
    private EntityManager em;

	
	public CategoriaFacade() {
		super(Categoria.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
	
	public Categoria buscarCategoria(String nombre) {
		try {
			String jpql = "SELECT categ FROM Categoria categ WHERE categ.nombre='" + nombre + "'";
			Categoria categ = (Categoria) em.createQuery(jpql).getSingleResult();
			return categ;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	

}
