package org.example;

import org.example.Classes.*;
import org.example.DAOs.CatalogDAO;
import org.example.DAOs.LoanDAO;
import org.example.DAOs.UserDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("catalog");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        CatalogDAO cd = new CatalogDAO(em);
        LoanDAO ld = new LoanDAO(em);
        UserDAO ud = new UserDAO(em);

        System.out.println("------Creating new books and magazines------");

        Book book1 = new Book("Il ragazzo e l'airone  ", 1995, 520, "Susumu Takahashi", "Drama");
        Book book2 = new Book("The Catcher in the Rye", 1951, 277, "J.D. Salinger", "Fiction");
        Book book3 = new Book("To Kill a Mockingbird", 1960, 281, "Harper Lee", "Classics");
        Book book4 = new Book("1984", 1949, 328, "George Orwell", "Dystopian Fiction");
        Book book5 = new Book("The Great Gatsby", 1925, 180, "F. Scott Fitzgerald", "Classics");
        Book book6 = new Book("Harry Potter and the Sorcerer's Stone", 1977, 309, "J.K. Rowling", "Fantasy");
        Magazine magazine1 = new Magazine("Novella2000", 2024, 150, Periodicity.WEEKLY);
        Magazine magazine2 = new Magazine("Time", 2024, 100, Periodicity.MONTHLY);
        Magazine magazine3 = new Magazine("National Geographic", 2024, 80, Periodicity.MONTHLY);
        Magazine magazine4 = new Magazine("Scientific American", 2024, 120, Periodicity.HALFYEARLY);
        Magazine magazine5 = new Magazine("Sports Illustrated", 2024, 64, Periodicity.WEEKLY);
        Magazine magazine6 = new Magazine("Cooking Light", 2024, 96, Periodicity.MONTHLY);
        cd.save(book1);
        cd.save(book2);
        cd.save(book3);
        cd.save(book4);
        cd.save(book5);
        cd.save(book6);
        cd.save(magazine1);
        cd.save(magazine2);
        cd.save(magazine3);
        cd.save(magazine4);
        cd.save(magazine5);
        cd.save(magazine6);


        System.out.println("------------------------------");

        System.out.println("------Creating new users------");
        User user1 = new User("Daniele", "Cagnoni", LocalDate.of(1996, 7, 23));
        User user2 = new User("Paperino", "Paperini", LocalDate.of(1994, 7, 23));
        User user3 = new User("Marco", "Meliconi", LocalDate.of(2000, 2, 20));

        ud.save(user1);
        ud.save(user2);
        ud.save(user3);

        System.out.println("------------------------------");

        System.out.println("------ Creating new loans------");
        Loan loan1 = new Loan(user1, book6, LocalDate.now());
        Loan loan2 = new Loan(user2, magazine3, LocalDate.of(1992, 7, 1));


        ld.save(loan1);
        ld.save(loan2);

        System.out.println("|||||SEARCH BY YEAR|||||");
        System.out.println(cd.searchByYear(1995));
        System.out.println("|||||SEARCH BY AUTHOR |||||");
        System.out.println(cd.searchByAuthor("George Orwell"));
        System.out.println("||||| SEARCH BY TITLE OR PART OF IT");
        System.out.println(cd.searchByTitle("Ha"));
        System.out.println("||||| SEARCH BY CARDNUM|||||");
        System.out.println(cd.searchByCardNum(1L));
        System.out.println("||||| SEARCH EXPIRED LOANS|||||");
        System.out.println(cd.searchExpiredLoans());


    }


}
