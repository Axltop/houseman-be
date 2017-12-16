package com.houseman.housemanbe.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "roles")
public class Role {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "role_id" , unique = true, nullable = false)
	private int id;

	@Column(name="role")
	private String role;

	@ManyToMany(mappedBy = "roles")
	private Set<User> users = new HashSet<User>();

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
}
