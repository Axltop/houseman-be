package com.houseman.housemanbe.dto;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tasks")
public class TaskDTO extends AbstractDTO {

    @Id
    @GeneratedValue
    @Column(name = "task_id", unique = true, nullable = false)
    private Long id;

    @Column(name = "task_name", unique = true, nullable = false)
    private String name;
    @Column(name = "task_description")
    private String description;

    @Column(name = "task_project_id")
    private int project;

    @OneToOne
    @JoinColumn(name =  "task_status_id")
    private TaskStatusDTO taskStatus;

    @OneToOne
    @JoinColumn(name="assigned_to")
    private UserDTO assignedTo;

    public TaskDTO() {
    }
}
