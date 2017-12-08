package com.houseman.housemanbe.dto;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "transaction_types")
public class TransactionTypeDTO {

    @Id
    @GeneratedValue
    @Column(name = "transaction_type_id", unique = true, nullable = false )
    private Long id;

    @Column(name = "transaction_type_name", unique = true)
    private String name;


}
