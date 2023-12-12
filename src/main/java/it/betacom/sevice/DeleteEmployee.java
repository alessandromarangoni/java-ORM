package it.betacom.sevice;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import it.betacom.entity.Employee;

public class DeleteEmployee {

    public static void main(String[] args) {
        // Creazione di un'istanza di EntityManagerFactory per la persistenza JPA
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("jpaProject");

        // Creazione di un'istanza di EntityManager per gestire le operazioni sulle entità
        EntityManager entityManager = emFactory.createEntityManager();

        // Inizio di una transazione per garantire l'integrità dei dati
        entityManager.getTransaction().begin();

        // Recupero l'oggetto Employee dal database utilizzando il suo ID (nel tuo caso, 2)
        Employee employee = entityManager.find(Employee.class, 2);

        // Rimuovo l'oggetto Employee dal database utilizzando il metodo remove
        entityManager.remove(employee);

        // Commit della transazione, che eliminerà effettivamente l'oggetto dal database
        entityManager.getTransaction().commit();

        // Chiusura dell'EntityManager e dell'EntityManagerFactory
        entityManager.close();
        emFactory.close();
    }
}
