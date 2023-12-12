package it.betacom.jpql;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import it.betacom.entity.Employee;

public class OperationExample {

	public static void main(String[] args) {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("jpaProject");
        EntityManager entityManager = emFactory.createEntityManager();
        Query query = entityManager.createQuery("SELECT UPPER(e.ename) FROM Employee e");
        List<String> list = query.getResultList();
        System.out.println("lista degli impiegati in maiuscolo");
        for (String s : list) {
        	System.out.println("nome: "+ s );
        }
        
        Query queryImpiegato = entityManager.createQuery("SELECT UPPER(i.nome) FROM Impiegato i");
        List<String> listImpiegato = queryImpiegato.getResultList();
        System.out.println("Lista degli impiegati in maiuscolo");
        for (String s : listImpiegato) {
            System.out.println("Nome: " + s);
        }

        
        Query queryMaxSalary = entityManager.createQuery("SELECT MAX(e.salary) FROM Employee e");
        Double Maxsalary = (Double) queryMaxSalary.getSingleResult();
        System.out.println(Maxsalary);
        
        
        Query queryListAsc = entityManager.createQuery("SELECT e FROM Employee e ORDER BY e.ename ASC");
        List<Employee> listEmployee = queryListAsc.getResultList();
        
        for(Employee e : listEmployee) {
        	System.out.println(e);
        }
        
        
        
        Query queryBetween = entityManager.createQuery("SELECT e FROM Employee e WHERE e.salary BETWEEN 100 AND 2000");
        
        List<Employee> listEmployeeBetween = queryBetween.getResultList();
        for(Employee e : listEmployeeBetween) {
        	System.out.println(e);
        }
        
        
        
        Query queryLike = entityManager.createQuery("SELECT e FROM Employee e WHERE e.ename LIKE '%s' ");
        
        List<Employee> listEmployeeLike = queryLike.getResultList();
        for(Employee e : listEmployeeLike) {
        	System.out.println(e);
        }
        
        entityManager.close();
        emFactory.close();
	}
}

