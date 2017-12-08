package com.houseman.housemanbe.dto;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "transaction_item_categories")
public class TransactionItemCategoryDTO extends AbstractDTO{

    @Id
    @GeneratedValue
    @Column(name = "transaction_item_category_id", unique = true, nullable = false)
    private Long id;

    @Column(name = "transaction_item_category_name")
    private String name;

    @Column(name = "transaction_item_category_description")
    private String description;

    public TransactionItemCategoryDTO() {

    }
}
