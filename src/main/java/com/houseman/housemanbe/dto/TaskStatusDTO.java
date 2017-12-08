package com.houseman.housemanbe.dto;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "task_statuses")
public class TaskStatusDTO extends AbstractDTO {

    @Id
    @GeneratedValue
    @Column(name="task_status_id", unique = true, nullable = false)
    private Long id;

    @Column(name="task_status_name", unique = true, nullable = false)
    private String name;
    @Column(name="task_status_description")
    private String description;

    public TaskStatusDTO() {
    }
}
