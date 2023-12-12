package it.betacom.jpql;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class OperationExample {

	public static void main(String[] args) {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("jpaProject");
        EntityManager entityManager = emFactory.createEntityManager();
        Query query = entityManager.createQuery("SELECT UPPER(e.ename) FROM Employee e");
        List<String> list = query.getResultList();
        System.out.println("lista degli impiegati in maiuscolo");
        for (String s : list) {
        	System.out.println("nome: "+ s );
        }
        entityManager.close();
        emFactory.close();
	}
}

