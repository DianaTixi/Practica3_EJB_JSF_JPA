package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entidad.Bodega;
import ec.edu.ups.entidad.Ciudad;

@Stateless
public class CiudadFacade extends AbstractFacade<Ciudad> {

	@PersistenceContext(unitName = "Prueba")
    private EntityManager em;
	
	public CiudadFacade() {
		super(Ciudad.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected EntityManager getEntityManager() {
        return em;
    }
	
	public Ciudad buscarCiudad(int id) {
		try {
			String jpql = "SELECT ciu FROM Ciudad ciu WHERE ciu.id=" +id ;
			Ciudad ciu = (Ciudad) em.createQuery(jpql).getSingleResult();
			return ciu;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public Ciudad buscarNombre(String nombre) {
			String jpql = "SELECT ciu FROM Ciudad ciu WHERE ciu.nombre='" + nombre +"'";
			Ciudad ciu = (Ciudad) em.createQuery(jpql).getSingleResult();
			return ciu;
	}
}
