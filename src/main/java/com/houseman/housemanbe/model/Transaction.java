package com.houseman.housemanbe.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="transactions")
public class Transaction extends AbstractModel {

    @Id
    @GeneratedValue
    @Column(name="transaction_id", unique=true, nullable = false)
    private String id;



    public Transaction() {
    }

}
