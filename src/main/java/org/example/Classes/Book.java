package org.example.Classes;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Book extends CatalogItem {
    private String author;
    private String genre;
    
}
