package it.betacom.sevice;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import it.betacom.entity.Employee;

public class UpdateEmployee {
    public static void main(String[] args) {
        // Creazione di un'istanza di EntityManagerFactory per la persistenza JPA
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("jpaProject");

        // Creazione di un'istanza di EntityManager per gestire le operazioni sulle entità
        EntityManager entityManager = emFactory.createEntityManager();

        // Inizio di una transazione per garantire l'integrità dei dati
        entityManager.getTransaction().begin();

        // Recupero l'oggetto Employee dal database utilizzando il suo ID (nel tuo caso, 1)
        Employee employee = entityManager.find(Employee.class, 1);

        // Modifica l'attributo salario dell'oggetto Employee
        employee.setSalary(2500);

        // Commit della transazione, che salverà effettivamente le modifiche nel database
        entityManager.getTransaction().commit();

        // Chiusura dell'EntityManager e dell'EntityManagerFactory
        entityManager.close();
        emFactory.close();
    }
}
