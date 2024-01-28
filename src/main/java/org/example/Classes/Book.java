package org.example.Classes;

import javax.persistence.Entity;

@Entity
public class Book extends CatalogItem {
    private String author;
    private String genre;


    public Book() {
    }

    public Book(String title, int publishingDate, int pageNumber, String author, String genre) {
        super(title, publishingDate, pageNumber);
        this.author = author;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                "} " + super.toString();
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
