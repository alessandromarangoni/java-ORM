package it.betacom.jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import it.betacom.entity.Employee;

public class NamedQuery {

    public static void main(String[] args) {
        // Creazione di un'istanza di EntityManagerFactory per la persistenza JPA
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("jpaProject");
        
        // Creazione di un'istanza di EntityManager per gestire le operazioni sulle entità
        EntityManager entityManager = emFactory.createEntityManager();
        
        // Creazione di una query JPA basata su una named query definita nell'entità Employee
        Query query = entityManager.createNamedQuery("find employee by id");
        
        // Impostazione del parametro ":id" nella query con il valore desiderato (1)
        query.setParameter("id", 1);
        
        // Esecuzione della query e recupero dei risultati come una lista di oggetti Employee
        List<Employee> list = query.getResultList();
        
        // Iterazione sulla lista di risultati e stampa dei nomi dei dipendenti
        for (Employee employee : list) {
            System.out.println(employee.getEname());
        }
        
        // Chiusura dell'EntityManager e dell'EntityManagerFactory
        entityManager.close();
        emFactory.close();
    }
}
