package com.houseman.housemanbe.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


/**
 * @version
 *
 * @author axltop
 *
 * */

@Entity
@Data
@Table(name = "users")
public class UserDTO extends AbstractDTO {

    @JsonIgnore
    public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder(12);

    @Id
    @Column(name="user_id",unique=true, nullable=false)
    @GeneratedValue
    private Long id;

    @Column(name="e_mail", unique = true, nullable=false)
    private String email;

    @Column(name="first_name",nullable=false)
    private String firstName;

    @Column(name="last_name", nullable = false)
    private String lastName;

    @Column(name = "password", nullable = false, length = 60)
//    @JsonIgnore
    private String password;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    private Set<RoleDTO> roles = new HashSet<RoleDTO>();


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "organizations_users",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "organization_id")}
    )
    private Set<OrganizationDTO> organizations = new HashSet<OrganizationDTO>();


    private UserDTO(){};

}
