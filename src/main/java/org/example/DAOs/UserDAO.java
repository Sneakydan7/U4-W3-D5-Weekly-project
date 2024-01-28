package org.example.DAOs;

import org.example.Classes.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UserDAO {
    private final EntityManager em;


    public UserDAO(EntityManager em) {
        this.em = em;
    }


    public void save(User user) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(user);
        transaction.commit();
        System.out.println(" user added with success");
    }

    public User getById(Long id) {
        return em.find(User.class, id);
    }

    public void deleteById(Long id) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(em.find(User.class, id));
        transaction.commit();
        System.out.println("user deleted with success");
    }
}
