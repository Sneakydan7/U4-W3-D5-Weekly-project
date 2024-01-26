package org.example.Classes;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "catalog_items")
public abstract class CatalogItem {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ISBN", nullable = false)
    private UUID isbn;
    @Column(nullable = false)
    private String title;
    @Column(name = "date_of_publishment")
    private LocalDate publishingDate;
    @Column(name = "number_of_pages")
    private int pageNumber;

}
