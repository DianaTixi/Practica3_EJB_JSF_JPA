package ec.edu.ups.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entidad.Empleados;
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
	
	public Pedido_Cabecera buscar(int id) {
		try {
			String jpql = "SELECT pc FROM Pedido_Cabecera pc WHERE pc.num_cabecera=" + id; 
			Pedido_Cabecera pedido = (Pedido_Cabecera) em.createQuery(jpql).getSingleResult();
			return pedido;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public List<Pedido_Cabecera> listaPedidos (int id) {
		try {
			String jpql = "SELECT pc FROM Pedido_Cabecera pc WHERE pc.empleado.id=" + id; 
			List<Pedido_Cabecera> lista = em.createQuery(jpql).getResultList();
			return lista;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
