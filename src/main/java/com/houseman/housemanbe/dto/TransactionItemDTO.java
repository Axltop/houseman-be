package com.houseman.housemanbe.dto;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "transaction_items")
public class TransactionItemDTO extends AbstractDTO {

    @Id
    @GeneratedValue
    @Column(name = "transaction_item_id", unique = true, nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transaction_id")
    private TransactionDTO transact;

    @Column(name = "amount")
    private BigDecimal amount;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "currency_name")
    private CurrencyDTO currency;


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "expense_items2expense_item_categories",
            joinColumns = {@JoinColumn(name = "expense_item_id")},
            inverseJoinColumns = {@JoinColumn(name = "expense_item_category_id")}
    )
    private Set<TransactionItemCategoryDTO> categories = new HashSet<TransactionItemCategoryDTO>();

}
