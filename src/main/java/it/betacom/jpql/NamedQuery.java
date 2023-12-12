package it.betacom.jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import it.betacom.entity.Employee;

public class NamedQuery {

	public static void main(String[] args) {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("jpaProject");
        EntityManager entityManager = emFactory.createEntityManager();
        Query query = entityManager.createNamedQuery("find employee by id");
        query.setParameter("id", 1);
        
        List<Employee> list = query.getResultList();
        for (Employee employee : list) {
            System.out.println(employee.getEname());
        }
        
        entityManager.close();
        emFactory.close();
	}

}
