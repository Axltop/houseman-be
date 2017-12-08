package com.houseman.housemanbe.dto;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

public class TransactionAbstract extends AbstractDTO{

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="transaction_created_by")
    private UserDTO createdBy;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="transaction_paid_by")
    private UserDTO paidBy;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transaction_type_id")
    private TransactionTypeDTO type;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_transaction_id")
    private TransactionDTO parentTransaction;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "transaction_status_id")
    private TransactionStatusDTO status;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transaction_project_id")
    private ProjectDTO project;
}
