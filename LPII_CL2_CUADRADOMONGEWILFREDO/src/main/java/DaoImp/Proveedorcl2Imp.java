package DaoImp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Interfaces.IProveedorcl2;
import model.TblProveedorcl2;


public class Proveedorcl2Imp implements IProveedorcl2{

	@Override
	public void RegistrarProveedorcl2(TblProveedorcl2 proveedorcl2) {
		// nos conectamos con la unidad de persistencia
		//para poder enviar datos
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("LPII_CL2_CUADRADOMONGEWILFREDO");
		EntityManager em=emf.createEntityManager();
		try{
		//iniciamos transaccion
		em.getTransaction().begin();
		//invocamos el metodo persist
		//para guardar datos en la bd
		em.persist(proveedorcl2);
		//confirmamos transaccion
		em.getTransaction().commit();
	}catch(RuntimeException e) {
	e.getMessage();
	}finally{	
		//cerramos
		em.close();
	}//fin del finally
	}
		
	

	@Override
	public void ActualizarProveedorcl2(TblProveedorcl2 proveedorcl2) {
		// nos conectamos con la unidad de persistencia
		// para actualizar los daros en la bd
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("LPII_CL2_CUADRADOMONGEWILFREDO");
		EntityManager em=emf.createEntityManager();
		try{
		//iniciamos transaccion
		em.getTransaction().begin();
		// invocamos el metodo que actualiza
		em.merge(proveedorcl2);
		//confirmamos
		em.getTransaction().commit();
		}catch(RuntimeException e){
			//enviamos mensaje si hay error
			e.getMessage();
		}finally{
		//cerramos
		em.close();
		
		}//fin del finally


}// fin actualizar

	@Override
	public void EliminarProveedorcl2(TblProveedorcl2 proveedorcl2) {
		// nos conectamos con la unidad de persistencia
				// para actualizar los daros en la bd
				EntityManagerFactory emf=Persistence.createEntityManagerFactory("LPII_CL2_CUADRADOMONGEWILFREDO");
				EntityManager em=emf.createEntityManager();
				// hacemos try
				
						try{
						//iniciamos la transaccion
						em.getTransaction().begin();
						//recuperamos el cod
						TblProveedorcl2 elipro=em.find(TblProveedorcl2.class,proveedorcl2.getIdprooveedorcl2());
						//aplicamos condicional
						if(elipro!=null){
							//procedemos a eliminar
							//el registro
							em.remove(elipro);
							//confirmamos
							em.getTransaction().commit();
							
							
						}//fin del condicional
						}catch(RuntimeException ex){
							//aplicamos otra condicional
							if(em.getTransaction().isActive())em.getTransaction().rollback();
							
						}finally{
							
							//cerramos
							em.close();
						}//fin de try catch finally

				
			}//fin eliminar

	@Override
	public List<TblProveedorcl2> ListadoProveedorcl2() {
		// nos conectamos con la unidad de persistencia
		// para actualizar los daros en la bd
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("LPII_CL2_CUADRADOMONGEWILFREDO");
		EntityManager em=emf.createEntityManager();
		List<TblProveedorcl2> listado=null;
//ponemos el try
		try{
		//iniciamos la transaccion
		em.getTransaction().begin();
		//aplicamos consultas JPQL
		listado=em.createQuery("select p from TblProveedorcl2 p",TblProveedorcl2.class).getResultList();
		//confirmamos
		em.getTransaction().commit();
		
		}catch(RuntimeException ex){
			ex.getMessage();
		}finally{
			//cerramos
			em.close();
		}
		return listado;

}// fin listado
	@Override
	public TblProveedorcl2 BuscarProveedorcl2(TblProveedorcl2 proveedorcl2) {
		// nos conectamos con la unidad de persistencia
				// para actualizar los daros en la bd
				EntityManagerFactory emf=Persistence.createEntityManagerFactory("LPII_CL2_CUADRADOMONGEWILFREDO");
				EntityManager em=emf.createEntityManager();
				TblProveedorcl2 tblpro=null;
				//ponemos el try
				try{
				//iniciamos la transaccion
				em.getTransaction().begin();
				tblpro=em.find(TblProveedorcl2.class,proveedorcl2.getIdprooveedorcl2());
				//confirmamos
				em.getTransaction().commit();
				}catch(RuntimeException ex){
					ex.getMessage();
				}finally{	
				//cerramos
				em.close();
				}//fin del finally
				//retornamos el cliente buscado
				return tblpro;

			}// fin buscar

}//fin
