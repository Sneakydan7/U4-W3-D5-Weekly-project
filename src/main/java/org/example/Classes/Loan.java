package org.example.Classes;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "loans")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "loan_id", nullable = false)
    private Long loanId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(nullable = false, name = "loaned_item")
    private CatalogItem loanedItem;
    @Column(name = "date_of_loan", nullable = false)
    private LocalDate dateOfLoan;
    @Column(name = "return_deadline", nullable = false)
    private LocalDate returnDeadline;

    @Column(name = "date_of_return")
    private LocalDate dateOfReturn;

    public Loan() {
    }


    public Long getLoanId() {
        return loanId;
    }

    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    public Loan(User user, CatalogItem loanedItem, LocalDate dateOfLoan) {
        this.user = user;
        this.loanedItem = loanedItem;
        this.dateOfLoan = dateOfLoan;
        this.returnDeadline = dateOfLoan.plusDays(30);

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public CatalogItem getLoanedItem() {
        return loanedItem;
    }

    public void setLoanedItem(CatalogItem loanedItem) {
        this.loanedItem = loanedItem;
    }

    public LocalDate getDateOfLoan() {
        return dateOfLoan;
    }

    public void setDateOfLoan(LocalDate dateOfLoan) {
        this.dateOfLoan = dateOfLoan;
    }

    public LocalDate getReturnDeadline() {
        return returnDeadline;
    }

    public void setReturnDeadline(LocalDate returnDeadline) {
        this.returnDeadline = returnDeadline;
    }

    public LocalDate getDateOfReturn() {
        return dateOfReturn;
    }

    public void setDateOfReturn(LocalDate dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "loanId=" + loanId +
                ", user=" + user +
                ", loanedItem=" + loanedItem +
                ", dateOfLoan=" + dateOfLoan +
                ", returnDeadline=" + returnDeadline +
                ", dateOfReturn=" + dateOfReturn +
                '}';
    }
}
