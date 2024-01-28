package org.example.DAOs;

import org.example.Classes.Loan;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class LoanDAO {
    private final EntityManager em;


    public LoanDAO(EntityManager em) {
        this.em = em;
    }


    public void save(Loan loan) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(loan);
        transaction.commit();
        System.out.println(" loan added with success");
    }

    public Loan getById(Long id) {
        return em.find(Loan.class, id);
    }

    public void deleteById(Loan id) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(em.find(Loan.class, id));
        transaction.commit();
        System.out.println("loan deleted with success");
    }
}
