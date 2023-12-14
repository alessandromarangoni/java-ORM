import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import it.betacom.entity.Employee;

public class CriteriaAPI {
    public static void main(String[] args) {

        // Creazione di un'istanza di EntityManagerFactory per la persistenza JPA
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("jpaProject");

        // Creazione di un'istanza di EntityManager per gestire le operazioni sulle entità
        EntityManager entityManager = emFactory.createEntityManager();

        // Ottenere un oggetto CriteriaBuilder per la creazione di query
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        // Creare una query CriteriaQuery di tipo Employee
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);

        // Creare un oggetto Root<Employee> per specificare l'entità di partenza della query
        Root<Employee> from = criteriaQuery.from(Employee.class);

        // Specificare che la query seleziona tutti gli elementi (SELECT * FROM Employee)
        CriteriaQuery<Employee> select = criteriaQuery.select(from);
;
        // Creare una query TypedQuery<Employee> basata sulla CriteriaQuery
        TypedQuery<Employee> typedQuery = entityManager.createQuery(select);

        // Eseguire la query e ottenere i risultati come una lista di oggetti Employee
        List<Employee> resultList = typedQuery.getResultList();

        System.out.println("Select all employees:");

        // Stampa i dettagli di ciascun dipendente
        for (Employee e : resultList) {
            System.out.println("Nome: " + e.getEname());
            // Aggiungi altre informazioni del dipendente se necessario
        }

        
        CriteriaQuery<Employee> select1 = criteriaQuery.select(from);
        
        select1.orderBy(criteriaBuilder.asc(from.get("ename")));
        TypedQuery<Employee> typedQuery1 = entityManager.createQuery(select1);
        List<Employee> resultList1 = typedQuery1.getResultList();
        System.out.println("Select all employees ordinati per nome:");

        // Stampa i dettagli di ciascun dipendente
        for (Employee e : resultList1) {
            System.out.println("Nome: " + e.getEname());
            // Aggiungi altre informazioni del dipendente se necessario
        }
        
        
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
	    CriteriaQuery<Employee> q = cb.createQuery(Employee.class);
	    Root<Employee> r = criteriaQuery.from(Employee.class);
	    
	    ParameterExpression<Double> p = cb.parameter(double.class);
	    q.select(r).where(cb.gt(r.get("salary"),p));
        TypedQuery<Employee> query = entityManager.createQuery(q);
        Double reqSalary = 2100.0;
        query.setParameter(p, reqSalary);
        List<Employee> list = query.getResultList();
        System.out.println("lista degli imppiegati con salario maggiore di 2100");
        System.out.println("lista: " + list);
        
        // Chiudere l'EntityManager e l'EntityManagerFactory
        entityManager.close();
        emFactory.close();
    }
}
