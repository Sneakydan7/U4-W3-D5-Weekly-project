package org.example.DAOs;

import org.example.Classes.CatalogItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
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
}
