package ec.edu.ups.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entidad.Empleados;
import ec.edu.ups.entidad.FacturaCabecera;
import ec.edu.ups.entidad.Pedido_Cabecera;

@Stateless
public class FacturaCabeceraFacade extends AbstractFacade<FacturaCabecera>{

	@PersistenceContext(unitName = "Prueba")
    private EntityManager em;
	

	
	public FacturaCabeceraFacade() {
		super(FacturaCabecera.class);
	}
	
	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
	
	public FacturaCabecera buscarF(int id) {
        try {
            String jpql = "SELECT fac FROM facturacabecera fac WHERE fac.numeroP=" + id;
            FacturaCabecera fac = (FacturaCabecera) em.createQuery(jpql).getSingleResult();
            return fac;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
	
	
	
	
}
