package it.betacom.sevice;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import it.betacom.entity.Employee;

public class DeleteEmployee {

	public static void main(String[] args) {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("jpaProject");
        EntityManager entityManager = emFactory.createEntityManager();
    // dopo aver ottenuto il manager apriamo la trasazione
        entityManager.getTransaction().begin();
        
        Employee employee = entityManager.find(Employee.class, 2);
        employee.setSalary(2500);
        
        entityManager.getTransaction().commit();
        entityManager.close();
        emFactory.close();
	}

}
