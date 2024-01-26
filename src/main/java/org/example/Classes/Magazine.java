package org.example.Classes;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "magazines")
public class Magazine extends CatalogItem {

    private Periodicity periodicity;
}
