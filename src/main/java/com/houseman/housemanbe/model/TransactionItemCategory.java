package com.houseman.housemanbe.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "transaction_item_categories")
public class TransactionItemCategory extends AbstractModel {

    @Id
    @GeneratedValue
    @Column(name = "transaction_item_category_id", unique = true, nullable = false)
    private Long id;

    @Column(name = "transaction_item_category_name")
    private String name;

    @Column(name = "transaction_item_category_description")
    private String description;

    public TransactionItemCategory() {

    }
}
