package com.esea.publicisSapient.repository.model;

import javax.persistence.*;

@Entity
@Table(name = "card")
public class Card {
    /*
    Object for card entity in the database

     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "cardNumber")
    private String cardNumber;

    @Column(name = "name")
    private String name;

    @Column(name = "cardLimit")
    private Long cardLimit;

    @Column(name = "balance")
    private Long balance;
    public String getNumber() {
        return cardNumber;
    }

    public void setNumber(String no) {
        this.cardNumber = no;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCardLimit() {
        return cardLimit;
    }

    public void setCardLimit(Long cardLimit) {
        this.cardLimit = cardLimit;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public void setId(long id) {
        this.id = id;
    }
}
