package com.houseman.housemanbe.dto;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "roles")
public class RoleDTO extends AbstractDTO {

    @Id
    @GeneratedValue
    @Column(name = "role_id", unique = true, nullable = false)
    private Long id;

    @Column(name = "role_name", unique = true, nullable = false)
    private String role;

//    @ManyToMany(mappedBy = "roles")
//    private Set<UserDTO> users = new HashSet<UserDTO>();

    private RoleDTO(){};


}
