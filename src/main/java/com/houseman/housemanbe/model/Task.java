package com.houseman.housemanbe.model;

import javax.persistence.*;

@Entity
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

    public Task(){
    }

    public Task(String name, String description, Long project, TaskStatus taskStatus, User assignedTo) {
        this.name = name;
        this.description = description;
        this.project = project;
        this.taskStatus = taskStatus;
        this.assignedTo = assignedTo;
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

    public Long getProject() {
        return project;
    }

    public void setProject(Long project) {
        this.project = project;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public User getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(User assignedTo) {
        this.assignedTo = assignedTo;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", project=" + project +
                ", taskStatus=" + taskStatus +
                ", assignedTo=" + assignedTo +
                '}';
    }
}
