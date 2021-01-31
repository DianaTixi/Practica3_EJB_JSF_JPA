package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entidad.Pedido_Cabecera;

@Stateless
public class PedidoCabeceraFacade extends AbstractFacade<Pedido_Cabecera>{
	
	@PersistenceContext(unitName = "Prueba")
	private EntityManager em;

	public PedidoCabeceraFacade() {
		super(Pedido_Cabecera.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
	
	public Pedido_Cabecera buscarP(int id) {
		try {
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	

}
