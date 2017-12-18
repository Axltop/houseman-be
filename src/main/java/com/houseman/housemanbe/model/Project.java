package com.houseman.housemanbe.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "projects")
public class Project extends AbstractModel {


    @Id
    @GeneratedValue
    @Column(name = "project_id", unique = true, nullable = false)
    private Long id;

    @Column(name = "project_name", unique = true, nullable = false)
    private String name;

    @Column(name = "project_decsription")
    private String description;

    @JoinColumn(name = "project_organization_id", nullable = false)
    @ManyToOne()
    private Organization organization;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "project",cascade = CascadeType.ALL)
    private Set<Task> tasks = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "project_watchers",
            joinColumns = {@JoinColumn(name = "project_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")}
    )
    private Set<User> watchers = new HashSet<User>();

    public Project() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<User> getWatchers() {
        return watchers;
    }

    public void setWatchers(Set<User> watchers) {
        this.watchers = watchers;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", watchers=" + watchers +
                ", organization=" + organization +
                ", tasks=" + tasks +
                '}';
    }
}
