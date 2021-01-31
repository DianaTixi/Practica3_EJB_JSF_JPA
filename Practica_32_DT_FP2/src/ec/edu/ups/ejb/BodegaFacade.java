package ec.edu.ups.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entidad.Bodega;
@Stateless
public class BodegaFacade extends AbstractFacade<Bodega>{
	
	@PersistenceContext(unitName = "Prueba")
    private EntityManager em; 
	
	public BodegaFacade() {
		super(Bodega.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
	
	public Bodega buscarBodega(String nombre) {
		try {
			String jpql = "SELECT bod FROM Bodega bod WHERE bod.nombre='" + nombre + "'";
			Bodega bod = (Bodega) em.createQuery(jpql).getSingleResult();
			return bod;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	public Bodega buscarBodegaC(int id) {
		try {
			String jpql = "SELECT bod FROM Bodega bod WHERE bod.id=" + id;
			Bodega bod = (Bodega) em.createQuery(jpql).getSingleResult();
			return bod;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	public List<Bodega>BuscarBodega(String nombre){
		String jpql = "SELECT bod FROM Bodega bod WHERE bod.nombre='" + nombre + "'";
		List<Bodega> bodega = em.createQuery(jpql).getResultList();
		return bodega;
	}
}
