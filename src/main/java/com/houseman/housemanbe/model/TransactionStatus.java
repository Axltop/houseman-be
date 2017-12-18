package com.houseman.housemanbe.model;

import javax.persistence.*;

@Entity
@Table(name = "transaction_statuses")
public class TransactionStatus {

    @Id
    @GeneratedValue
    @Column(name = "transaction_status_id", unique = true, nullable = false)
    private Long id;

    @Column(name= "transaction_status_name", unique = true, nullable = false)
    private String name;

    public TransactionStatus(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TransactionStatus{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
