package com.houseman.housemanbe.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tasks")
public class Task extends AbstractModel {

    @Id
    @GeneratedValue
    @Column(name = "task_id", unique = true, nullable = false)
    private Long id;

    @Column(name = "task_name", unique = true, nullable = false)
    private String name;
    @Column(name = "task_description")
    private String description;

    @Column(name = "task_project_id")
    private Long project;

    @OneToOne
    @JoinColumn(name =  "task_status_id")
    private TaskStatus taskStatus;

    @OneToOne
    @JoinColumn(name="assigned_to")
    private User assignedTo;

    public Task() {
    }
}
