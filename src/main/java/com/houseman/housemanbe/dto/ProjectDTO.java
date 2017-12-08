package com.houseman.housemanbe.dto;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "projects")
public class ProjectDTO extends AbstractDTO {

    @Id
    @GeneratedValue
    @Column(name = "project_id", unique = true, nullable = false)
    private Long id;

    @Column(name = "project_name", unique = true, nullable = false)
    private String name;

    @Column(name = "project_decsription")
    private String description;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "project_watchers",
            joinColumns = {@JoinColumn(name = "project_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")}
    )
    private Set<UserDTO> watchers = new HashSet<UserDTO>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "project",cascade = CascadeType.ALL)
    private Set<TaskDTO> tasks = new HashSet<>();

    public ProjectDTO() {
    }
}
