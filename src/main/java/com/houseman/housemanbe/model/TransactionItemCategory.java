package com.houseman.housemanbe.model;

import javax.persistence.*;

@Entity
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

    public TransactionItemCategory(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return "TransactionItemCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
