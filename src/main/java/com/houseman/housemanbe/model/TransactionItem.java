package com.houseman.housemanbe.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "transaction_items")
public class TransactionItem extends AbstractModel {

    @Id
    @GeneratedValue
    @Column(name = "transaction_item_id", unique = true, nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transaction_id")
    private Transaction transact;

    @Column(name = "amount")
    private BigDecimal amount;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "currency_name")
    private Currency currency;


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "expense_items2expense_item_categories",
            joinColumns = {@JoinColumn(name = "expense_item_id")},
            inverseJoinColumns = {@JoinColumn(name = "expense_item_category_id")}
    )
    private Set<TransactionItemCategory> categories = new HashSet<TransactionItemCategory>();

    public TransactionItem(){
    }

    public TransactionItem(Transaction transact, BigDecimal amount, Currency currency, Set<TransactionItemCategory> categories) {
        this.transact = transact;
        this.amount = amount;
        this.currency = currency;
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "TransactionItem{" +
                "id=" + id +
                ", transact=" + transact +
                ", amount=" + amount +
                ", currency=" + currency +
                ", categories=" + categories +
                '}';
    }
}
