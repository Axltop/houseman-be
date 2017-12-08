package com.houseman.housemanbe.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "currencies")
public class CurrencyDTO extends AbstractDTO {

    @Id
    @Column(name="currency_name", unique = true, nullable = false)
    private String name;

}
