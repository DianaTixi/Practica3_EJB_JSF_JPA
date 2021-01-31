package ec.edu.ups.ejb;

import java.beans.Statement;
import java.sql.ResultSet;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entidad.Bodega;
import ec.edu.ups.entidad.BodegaProducto;
import ec.edu.ups.entidad.Producto;

@Stateless
public class BodegaProductoFacade extends AbstractFacade<BodegaProducto>{

	public BodegaProductoFacade() {
		super(BodegaProducto.class);
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext(unitName = "Prueba")
    private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
	/*
	public BodegaProducto TotalProductos(){
		String jpql = "SELECT sum(bp.stock) FROM BodegaProducto bp ";
		
	 return (BodegaProducto) em.createQuery(jpql).getSingleResult();
		
	}*/
	public List<BodegaProducto>InventarioBodega(int id){
		String jpql = "SELECT bp FROM BodegaProducto bp  WHERE bp.bodega.id="+id;
		List<BodegaProducto> bodegaProducto = em.createQuery(jpql).getResultList();
		return bodegaProducto;
	}
	
	public BodegaProducto buscar(int idB , int idP) {
		try {
			String jpql = "SELECT bp FROM BodegaProducto bp WHERE bp.bodega.id=" + idB + " AND bp.producto.id="+idP;
			BodegaProducto bodegap = (BodegaProducto) em.createQuery(jpql).getSingleResult();
			return bodegap;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
}
