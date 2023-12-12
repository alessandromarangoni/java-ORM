package it.betacom.jpql;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import it.betacom.entity.Employee;

public class OperationExample {

    public static void main(String[] args) {
        // Creazione dell'EntityManagerFactory basato sul file di configurazione "persistence.xml"
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("jpaProject");
        // Creazione dell'EntityManager
        EntityManager entityManager = emFactory.createEntityManager();
        
        // Query per selezionare i nomi degli impiegati in maiuscolo
        Query query = entityManager.createQuery("SELECT UPPER(e.ename) FROM Employee e");
        List<String> list = query.getResultList();
        System.out.println("Lista degli impiegati in maiuscolo");
        for (String s : list) {
            System.out.println("Nome: " + s);
        }
        
        // Query per selezionare i nomi degli impiegati di un'altra entità "Impiegato" in maiuscolo
        Query queryImpiegato = entityManager.createQuery("SELECT UPPER(i.nome) FROM Impiegato i");
        List<String> listImpiegato = queryImpiegato.getResultList();
        System.out.println("Lista degli impiegati (entità Impiegato) in maiuscolo");
        for (String s : listImpiegato) {
            System.out.println("Nome: " + s);
        }
        
        // Query per trovare il massimo stipendio tra gli impiegati
        Query queryMaxSalary = entityManager.createQuery("SELECT MAX(e.salary) FROM Employee e");
        Double maxSalary = (Double) queryMaxSalary.getSingleResult();
        System.out.println("Massimo stipendio tra gli impiegati: " + maxSalary);
        
        // Query per selezionare gli impiegati in ordine alfabetico crescente
        Query queryListAsc = entityManager.createQuery("SELECT e FROM Employee e ORDER BY e.ename ASC");
        List<Employee> listEmployee = queryListAsc.getResultList();
        System.out.println("Lista degli impiegati in ordine alfabetico crescente");
        for (Employee e : listEmployee) {
            System.out.println(e);
        }
        
        // Query per selezionare gli impiegati con stipendio compreso tra 100 e 2000
        Query queryBetween = entityManager.createQuery("SELECT e FROM Employee e WHERE e.salary BETWEEN 100 AND 2000");
        List<Employee> listEmployeeBetween = queryBetween.getResultList();
        System.out.println("Lista degli impiegati con stipendio compreso tra 100 e 2000");
        for (Employee e : listEmployeeBetween) {
            System.out.println(e);
        }
        
        // Query per selezionare gli impiegati il cui nome termina con 's'
        Query queryLike = entityManager.createQuery("SELECT e FROM Employee e WHERE e.ename LIKE '%s'");
        List<Employee> listEmployeeLike = queryLike.getResultList();
        System.out.println("Lista degli impiegati il cui nome termina con 's'");
        for (Employee e : listEmployeeLike) {
            System.out.println(e);
        }
        
        // Inizia una transazione per eliminare gli impiegati con uno stipendio superiore a 2000
        entityManager.getTransaction().begin();
        Query queryDelete = entityManager.createQuery("DELETE FROM Employee e WHERE e.salary > :p");
        int deleteEmployee = queryDelete.setParameter("p", 2000).executeUpdate();
        System.out.println("Numero di impiegati eliminati: " + deleteEmployee);
        entityManager.getTransaction().commit(); // Conferma la transazione
        
        // Chiudi l'EntityManager e l'EntityManagerFactory
        entityManager.close();
        emFactory.close();
        
        
        
    }
}

