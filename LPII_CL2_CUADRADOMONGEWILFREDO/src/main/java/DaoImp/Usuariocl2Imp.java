package DaoImp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Interfaces.IUsuariocl2;
import model.TblUsuariocl2;

public class Usuariocl2Imp implements IUsuariocl2 {

	@Override
	public void RegistrarUsuariocl2(TblUsuariocl2 usuariocl2) {
		// nos conectamos con la unidad de persistencia
				//para poder enviar datos
				EntityManagerFactory emf=Persistence.createEntityManagerFactory("LPII_CL2_CUADRADOMONGEWILFREDO");
				EntityManager em=emf.createEntityManager();
				try{
				//iniciamos transaccion
				em.getTransaction().begin();
				//invocamos el metodo persist
				//para guardar datos en la bd
				em.persist(usuariocl2);
				//confirmamos transaccion
				em.getTransaction().commit();
			}catch(RuntimeException e) {
			e.getMessage();
			}finally{	
				//cerramos
				em.close();
			}//fin del finally

	}//fin registar
	@Override
	public void ActualizarUsuariocl2(TblUsuariocl2 usuariocl2) {
		// nos conectamos con la unidad de persistencia
				// para actualizar los daros en la bd
				EntityManagerFactory emf=Persistence.createEntityManagerFactory("LPII_CL2_CUADRADOMONGEWILFREDO");
				EntityManager em=emf.createEntityManager();
				try{
				//iniciamos transaccion
				em.getTransaction().begin();
				// invocamos el metodo que actualiza
				em.merge(usuariocl2);
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
	public void EliminarUsuariocl2(TblUsuariocl2 usuariocl2) {
		// nos conectamos con la unidad de persistencia
		// para actualizar los daros en la bd
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("LPII_CL2_CUADRADOMONGEWILFREDO");
		EntityManager em=emf.createEntityManager();
		// hacemos try
		
				try{
				//iniciamos la transaccion
				em.getTransaction().begin();
				//recuperamos el cod
				TblUsuariocl2 eliusu=em.find(TblUsuariocl2.class,usuariocl2.getIdusuariocl2());
				//aplicamos condicional
				if(eliusu!=null){
					//procedemos a eliminar
					//el registro
					em.remove(eliusu);
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
	public List<TblUsuariocl2> ListadoUsuariocl2() {
		// nos conectamos con la unidad de persistencia
				// para actualizar los daros en la bd
				EntityManagerFactory emf=Persistence.createEntityManagerFactory("LPII_CL2_CUADRADOMONGEWILFREDO");
				EntityManager em=emf.createEntityManager();
				List<TblUsuariocl2> listado=null;
		//ponemos el try
				try{
				//iniciamos la transaccion
				em.getTransaction().begin();
				//aplicamos consultas JPQL
				listado=em.createQuery("select u from TblUsuariocl2 u",TblUsuariocl2.class).getResultList();
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
	public TblUsuariocl2 BuscarUsuariocl2(TblUsuariocl2 usuariocl2) {
		// nos conectamos con la unidad de persistencia
		// para actualizar los daros en la bd
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("LPII_CL2_CUADRADOMONGEWILFREDO");
		EntityManager em=emf.createEntityManager();
		TblUsuariocl2 tblusu=null;
		//ponemos el try
		try{
		//iniciamos la transaccion
		em.getTransaction().begin();
		tblusu=em.find(TblUsuariocl2.class,usuariocl2.getIdusuariocl2());
		//confirmamos
		em.getTransaction().commit();
		}catch(RuntimeException ex){
			ex.getMessage();
		}finally{	
		//cerramos
		em.close();
		}//fin del finally
		//retornamos el cliente buscado
		return tblusu;

	}// fin buscar

}
