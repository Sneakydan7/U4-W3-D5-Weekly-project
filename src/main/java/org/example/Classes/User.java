package org.example.Classes;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "card_number", nullable = false)
    private Long cardNumber;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String lastName;
    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    public Long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
    }
}
