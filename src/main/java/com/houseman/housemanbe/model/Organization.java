package com.houseman.housemanbe.model;

import javax.persistence.*;

@Entity
@Table(name = "organizations")
public class Organization extends AbstractModel {

    @Id
    @GeneratedValue
    @Column(name = "organization_id", unique = true, nullable = false)
    private Long id;

    @Column(name = "organization_name")
    private String name;

    public Organization(){
    }

    public Organization(String name) {
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
        return "Organization{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
