package it.betacom.sevice;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import it.betacom.entity.Employee;
import it.betacom.entity.Impiegato;

public class CreateImpiegato {

	public static void main(String[] args) {

	    
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("jpaProject");
        EntityManager entityManager = emFactory.createEntityManager();
    // dopo aver ottenuto il manager apriamo la trasazione
        entityManager.getTransaction().begin();
        Impiegato impiegato = new Impiegato();
        impiegato.setNome("ginmarco");
        impiegato.setSalario(2000);
        impiegato.setTitolo("Java Developer");
        entityManager.persist(impiegato);
        
        
        Impiegato impiegato2 = new Impiegato();
        impiegato2.setNome("giovanni");
        impiegato2.setSalario(2100);
        impiegato2.setTitolo("Php Developer");
        entityManager.persist(impiegato2);
        
        entityManager.getTransaction().commit();
        entityManager.close();
        emFactory.close();
	}

}
