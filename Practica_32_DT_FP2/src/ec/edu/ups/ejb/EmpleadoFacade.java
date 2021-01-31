package ec.edu.ups.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import ec.edu.ups.entidad.Empleados;

@Stateless
public class EmpleadoFacade extends AbstractFacade<Empleados>{
	
	@PersistenceContext(unitName = "Prueba")
    private EntityManager em;
	
	public EmpleadoFacade() {
		super(Empleados.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
	
	public Empleados buscarEmp (String email, String contrasena) {
		try {
			String jpql = "SELECT emp FROM Empleados emp WHERE emp.email='" + email + "'"+"  AND  emp.password='"+contrasena+"'";
			Empleados empleado = (Empleados) em.createQuery(jpql).getSingleResult();
			return empleado;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Empleados findEmp (int id) {
		try {
			String jpql = "SELECT emp FROM Empleados emp WHERE emp.id="+id;
			Empleados empleado = (Empleados) em.createQuery(jpql).getSingleResult();
			return empleado;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Empleados>listaClientes(char rol){
		String jpql = "SELECT emp FROM Empleados emp WHERE emp.rol='" + rol + "'";
		List<Empleados>empleados = em.createQuery(jpql).getResultList();
		
		return empleados;
		
	}
	
	public List<Empleados>buscarC(char  estado,char  rol){
		String jpql = "SELECT emp FROM Empleados emp WHERE emp.estado='" + estado+ "'"+"  AND  emp.rol='" + rol + "'";
		List<Empleados>empleados = em.createQuery(jpql).getResultList();
		return empleados;
	}
	
	public List<Empleados>buscarCli(String cedula){
		String jpql = "SELECT emp FROM Empleados emp WHERE emp.cedula='" + cedula + "'";
		List<Empleados>empleados = em.createQuery(jpql).getResultList();
		return empleados;
	}
	
	public Empleados buscarEmp (String cedula) {
		try {
			String jpql = "SELECT emp FROM Empleados emp WHERE emp.cedula='" + cedula + "'";
			Empleados empleado = (Empleados) em.createQuery(jpql).getSingleResult();
			return empleado;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
