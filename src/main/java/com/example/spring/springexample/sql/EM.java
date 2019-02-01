//package com.example.spring.springexample.sql;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
//import javax.persistence.Persistence;
//
//public class EM {
//
//	private EntityManager em;
//
//	public EM(EntityManager em) {
//		this.em = em;
//	}
//
//	public static void main(String[] args) {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("sqlr");
//		EM clazz = new EM(emf.createEntityManager());
//
//		EntityTransaction transaction = clazz.em.getTransaction();
//
//		transaction.begin();
//
////		clazz.handleQuery(clazz.em);
//
//		T2 t2 = new T2("black");
//		clazz.em.persist(t2);
//
//
//		transaction.commit();
//
//		clazz.em.close();
//		emf.close();
//	}
//
////	public void handleQuery(EntityManager em) {
////
////		T2 t2 = new T2("black");
////		em.persist(t2);
////
////	}
//
//}
