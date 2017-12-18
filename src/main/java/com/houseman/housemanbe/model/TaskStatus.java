package com.houseman.housemanbe.model;

import javax.persistence.*;

@Entity
@Table(name = "task_statuses")
public class TaskStatus extends AbstractModel {

    @Id
    @GeneratedValue
    @Column(name="task_status_id", unique = true, nullable = false)
    private Long id;

    @Column(name="task_status_name", unique = true, nullable = false)
    private String name;

    @Column(name="task_status_description")
    private String description;

    public TaskStatus(){
    }

    public TaskStatus(String name, String description) {
        this.name = name;
        this.description = description;
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

    @Override
    public String toString() {
        return "TaskStatus{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
