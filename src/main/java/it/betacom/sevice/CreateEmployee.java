package it.betacom.sevice;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import it.betacom.entity.Employee;

public class CreateEmployee {
    public static void main(String[] args) {

    
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("jpaProject");
        EntityManager entityManager = emFactory.createEntityManager();
    // dopo aver ottenuto il manager apriamo la trasazione
        entityManager.getTransaction().begin();
        Employee employee = new Employee();
        employee.setEname("Maria");
        employee.setSalary(2000);
        employee.setDeg("Java Developer");
        entityManager.persist(employee);
        
        
        Employee employee2 = new Employee();
        employee2.setEname("Sergio");
        employee2.setSalary(2100);
        employee2.setDeg("Php Developer");
        entityManager.persist(employee2);
        
        entityManager.getTransaction().commit();
        entityManager.close();
        emFactory.close();
    }
}
