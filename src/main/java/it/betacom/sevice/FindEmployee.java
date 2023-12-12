package it.betacom.sevice;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import it.betacom.entity.Employee;

public class FindEmployee {
public static void main(String[] args) {
		
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("jpaProject");
        EntityManager entityManager = emFactory.createEntityManager();
    // dopo aver ottenuto il manager apriamo la trasazione
        Employee employee = entityManager.find(Employee.class, 2);
        System.out.println(employee.toString());
        entityManager.close();
        emFactory.close();

	}
}
