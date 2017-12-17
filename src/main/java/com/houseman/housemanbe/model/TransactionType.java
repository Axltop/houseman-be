package com.houseman.housemanbe.model;

import javax.persistence.*;

@Entity
@Table(name = "transaction_types")
public class TransactionType {

    @Id
    @GeneratedValue
    @Column(name = "transaction_type_id", unique = true, nullable = false )
    private Long id;

    @Column(name = "transaction_type_name", unique = true)
    private String name;

    public TransactionType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TransactionType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
