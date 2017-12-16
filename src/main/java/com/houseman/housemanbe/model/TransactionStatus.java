package com.houseman.housemanbe.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "transaction_statuses")
public class TransactionStatus {

    @Id
    @GeneratedValue
    @Column(name = "transaction_status_id", unique = true, nullable = false)
    private Long id;

    @Column(name= "transaction_status_name", unique = true, nullable = false)
    private String name;

    public TransactionStatus() {
    }
}
