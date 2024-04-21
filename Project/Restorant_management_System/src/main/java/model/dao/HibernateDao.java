package model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;



public class HibernateDao {
	
	static EntityManagerFactory emf;
	static EntityManager em;
	static EntityTransaction et;
	
	static{
		emf=Persistence.createEntityManagerFactory("restaurant_management_system");
		em=emf.createEntityManager();
		et=em.getTransaction();
	}
	public static void main(String[] args) {
		HibernateDao hdao=new HibernateDao();
		System.out.println(hdao);
	}

}
