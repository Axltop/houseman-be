package com.houseman.housemanbe.dto;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="transactions")
public class TransactionDTO extends TransactionAbstract {

    @Id
    @GeneratedValue
    @Column(name="transaction_id", unique=true, nullable = false)
    private String id;



    public TransactionDTO() {
    }

}
