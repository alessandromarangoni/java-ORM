package it.betacom.sevice;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import it.betacom.entity.Impiegato; // Assicurati di importare la classe Impiegato corretta

public class CreateImpiegato {

    public static void main(String[] args) {

        // Creazione di un'istanza di EntityManagerFactory per la persistenza JPA
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("jpaProject");

        // Creazione di un'istanza di EntityManager per gestire le operazioni sulle entità
        EntityManager entityManager = emFactory.createEntityManager();

        // Inizio di una transazione per garantire l'integrità dei dati
        entityManager.getTransaction().begin();

        // Creazione di un oggetto Impiegato e impostazione dei suoi attributi
        Impiegato impiegato = new Impiegato();
        impiegato.setNome("ginmarco");
        impiegato.setSalario(2000);
        impiegato.setTitolo("Java Developer");

        // Salvataggio dell'oggetto Impiegato nel database utilizzando persist
        entityManager.persist(impiegato);

        // Creazione di un altro oggetto Impiegato e impostazione dei suoi attributi
        Impiegato impiegato2 = new Impiegato();
        impiegato2.setNome("giovanni");
        impiegato2.setSalario(2100);
        impiegato2.setTitolo("Php Developer");

        // Salvataggio dell'oggetto Impiegato2 nel database utilizzando persist
        entityManager.persist(impiegato2);

        // Commit della transazione, che salverà effettivamente le modifiche nel database
        entityManager.getTransaction().commit();

        // Chiusura dell'EntityManager e dell'EntityManagerFactory
        entityManager.close();
        emFactory.close();
    }
}
