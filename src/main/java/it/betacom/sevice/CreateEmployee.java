package it.betacom.sevice;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import it.betacom.entity.Employee;

public class CreateEmployee {
    public static void main(String[] args) {

        // Creazione di un'istanza di EntityManagerFactory per la persistenza JPA
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("jpaProject");

        // Creazione di un'istanza di EntityManager per gestire le operazioni sulle entità
        EntityManager entityManager = emFactory.createEntityManager();

        // Inizio di una transazione per garantire l'integrità dei dati
        entityManager.getTransaction().begin();

        // Creazione di un oggetto Employee e impostazione dei suoi attributi
        Employee employee = new Employee();
        employee.setEname("gianni");
        employee.setSalary(2000);
        employee.setDeg("Java Developer");

        // Salvataggio dell'oggetto Employee nel database utilizzando persist
        entityManager.persist(employee);

        // Creazione di un altro oggetto Employee e impostazione dei suoi attributi
        Employee employee2 = new Employee();
        employee2.setEname("mario");
        employee2.setSalary(2100);
        employee2.setDeg("Php Developer");

        // Salvataggio dell'oggetto Employee2 nel database utilizzando persist
        entityManager.persist(employee2);

        // Commit della transazione, che salverà effettivamente le modifiche nel database
        entityManager.getTransaction().commit();

        // Chiusura dell'EntityManager e dell'EntityManagerFactory
        entityManager.close();
        emFactory.close();
    }
}
