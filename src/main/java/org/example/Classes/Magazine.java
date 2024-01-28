package org.example.Classes;

import javax.persistence.Entity;

@Entity
public class Magazine extends CatalogItem {

    private Periodicity periodicity;

    public Magazine() {
    }

    public Magazine(String title, int publishingDate, int pageNumber, Periodicity periodicity) {
        super(title, publishingDate, pageNumber);
        this.periodicity = periodicity;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "periodicity=" + periodicity +
                "} " + super.toString();
    }


    public Periodicity getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(Periodicity periodicity) {
        this.periodicity = periodicity;
    }
}
