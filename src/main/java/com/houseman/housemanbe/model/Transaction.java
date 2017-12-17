package com.houseman.housemanbe.model;

import javax.persistence.*;

@Entity
@Table(name="transactions")
public class Transaction extends AbstractModel {

    @Id
    @GeneratedValue
    @Column(name="transaction_id", unique=true, nullable = false)
    private String id;

    public Transaction() {
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                '}';
    }
}
