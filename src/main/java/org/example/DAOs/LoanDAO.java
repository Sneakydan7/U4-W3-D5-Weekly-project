package org.example.DAOs;

import org.example.Classes.CatalogItem;
import org.example.Classes.Loan;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.UUID;

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

    public CatalogItem getByISBN() {
        return em.find(CatalogItem.class, isbn);
    }

    public void deleteByISBN(UUID isbn) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(em.find(CatalogItem.class, isbn));
        transaction.commit();
        System.out.println("item deleted with success");
    }
}
