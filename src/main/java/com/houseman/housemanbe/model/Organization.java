package com.houseman.housemanbe.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "organizations")
public class Organization {

    @Id
    @GeneratedValue
    @Column(name = "organization_id", unique = true, nullable = false)
    private Long id;

    @Column(name = "organization_name")
    private String name;

    public Organization() {
    }
}
