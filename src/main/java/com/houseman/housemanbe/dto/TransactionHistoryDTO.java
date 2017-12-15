package com.houseman.housemanbe.dto;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="history_transactions")
public class TransactionHistoryDTO {
    @Id
    @Column(name = "history_transaction_id", unique = true, nullable = false)
    @GeneratedValue
    private String id;

    public TransactionHistoryDTO() {
    }
}
