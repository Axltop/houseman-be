package com.houseman.housemanbe.dto;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "organizations")
public class OrganizationDTO {

    @Id
    @GeneratedValue
    @Column(name = "organization_id", unique = true, nullable = false)
    private Long id;

    @Column(name = "organization_name",  unique = true, nullable = true)
    private String name;

    public OrganizationDTO() {
    }
}
