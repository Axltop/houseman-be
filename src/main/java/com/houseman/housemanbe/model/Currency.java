package com.houseman.housemanbe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "currencies")
public class Currency extends AbstractModel {

    @Id
    @Column(name="currency_name", unique = true, nullable = false)
    private String name;

    public Currency(){
    }

    public Currency(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "name='" + name + '\'' +
                '}';
    }
}
