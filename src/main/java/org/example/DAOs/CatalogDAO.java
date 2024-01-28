package org.example.DAOs;

import org.example.Classes.CatalogItem;
import org.example.Classes.Loan;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.UUID;

public class CatalogDAO {
    private final EntityManager em;


    public CatalogDAO(EntityManager em) {
        this.em = em;
    }


    public void save(CatalogItem item) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(item);
        transaction.commit();
        System.out.println(" item added with success");
    }

    public CatalogItem getByISBN(UUID isbn) {
        return em.find(CatalogItem.class, isbn);
    }

    public void deleteByISBN(UUID isbn) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(em.find(CatalogItem.class, isbn));
        transaction.commit();
        System.out.println("item deleted with success");
    }

    public List<CatalogItem> searchByYear(int year) {
        return em.createNamedQuery("search_by_year", CatalogItem.class).setParameter("year", year).getResultList();
    }

    public List<CatalogItem> searchByAuthor(String author) {
        return em.createNamedQuery("search_by_author", CatalogItem.class).setParameter("author", author).getResultList();
    }

    public List<CatalogItem> searchByTitle(String title) {
        return em.createNamedQuery("search_by_title", CatalogItem.class).setParameter("title", "%" + title + "%").getResultList();
    }


    public List<Loan> searchByCardNum(Long cardNum) {
        TypedQuery<Loan> query = em.createQuery("SELECT loan FROM Loan loan WHERE loan.user.cardNumber=:cardNum AND loan.dateOfReturn IS NULL", Loan.class);
        query.setParameter("cardNum", cardNum);
        return query.getResultList();

    }

    public List<Loan> searchExpiredLoans() {
        return em.createQuery("SELECT loan FROM Loan loan WHERE loan.returnDeadline < NOW() AND loan.dateOfReturn IS NULL", Loan.class).getResultList();
    }
}
