package com.houseman.housemanbe.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "currencies")
public class Currency extends AbstractModel {

    @Id
    @Column(name="currency_name", unique = true, nullable = false)
    private String name;

}
