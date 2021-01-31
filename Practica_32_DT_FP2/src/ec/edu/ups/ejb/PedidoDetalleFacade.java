package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entidad.Pedido_Detalle;

@Stateless
public class PedidoDetalleFacade extends AbstractFacade<Pedido_Detalle>{
	
	@PersistenceContext(unitName = "Prueba")
    private EntityManager em;

	public PedidoDetalleFacade() {
		super(Pedido_Detalle.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}

	
}
