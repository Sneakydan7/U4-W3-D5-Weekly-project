package org.example.Classes;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "catalog_items")
@NamedQuery(name = "search_by_year", query = " SELECT c FROM CatalogItem c WHERE c.publishingDate=:year")
@NamedQuery(name = "search_by_author", query = " SELECT c FROM CatalogItem c WHERE c.author=:author")
@NamedQuery(name = "search_by_title", query = " SELECT c FROM CatalogItem c WHERE LOWER(c.title) LIKE LOWER(:title)")
public abstract class CatalogItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ISBN", nullable = false)
    private UUID isbn;
    @Column(nullable = false)
    private String title;
    @Column(name = "date_of_publishing")
    private int publishingDate;
    @Column(name = "number_of_pages")
    private int pageNumber;

    protected CatalogItem() {
    }

    public CatalogItem(String title, int publishingDate, int pageNumber) {
        this.title = title;
        this.publishingDate = publishingDate;
        this.pageNumber = pageNumber;
    }

    @Override
    public String toString() {
        return "CatalogItem{" +
                "isbn=" + isbn +
                ", title='" + title + '\'' +
                ", publishingDate=" + publishingDate +
                ", pageNumber=" + pageNumber +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublishingDate() {
        return publishingDate;
    }

    public void setPublishingDate(int publishingDate) {
        this.publishingDate = publishingDate;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }
}
