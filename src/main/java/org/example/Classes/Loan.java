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
    @OneToMany
    @Column(nullable = false, name = "loaned_item")
    private CatalogItem loanedItem;
    @Column(name = "date_of_loan", nullable = false)
    private LocalDate dateOfLoan;
    @Column(name = "return_deadline", nullable = false)
    private LocalDate returnDeadline;

    @Column(name = "date_of_return", nullable = false)
    private LocalDate dateOfReturn;


    public Long getLoanId() {
        return loanId;
    }

    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }
}
