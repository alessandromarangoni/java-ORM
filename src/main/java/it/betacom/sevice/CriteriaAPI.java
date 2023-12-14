package it.betacom.sevice; // Il package in cui è contenuto il tuo codice

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import it.betacom.entity.Employee; // Importazione della classe Employee da utilizzare

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

        // Proviamo ad estrarre impiegati con un salario maggiore di un certo valore
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> q = cb.createQuery(Employee.class);
        Root<Employee> r = criteriaQuery.from(Employee.class);
        ParameterExpression<Double> p = cb.parameter(double.class);

        // Costruiamo la query per selezionare gli impiegati con salario maggiore di un valore specifico
        q.select(r).where(cb.gt(r.get("salary"), p));
        TypedQuery<Employee> query = entityManager.createQuery(q);
        Double reqSalary = 2100.0; // Salario richiesto
        query.setParameter(p, reqSalary);
        List<Employee> list = query.getResultList();

        System.out.println("Impiegati con salario maggiore di " + reqSalary);
        System.out.println("Lista: " + list);

        // Chiudere l'EntityManager e l'EntityManagerFactory
        entityManager.close();
        emFactory.close();
    }
}
