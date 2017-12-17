package com.houseman.housemanbe.model;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role extends AbstractModel{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "role_id" , unique = true, nullable = false)
	private int id;

	@Column(name="role_name")
	private String roleName;

//	@ManyToMany(mappedBy = "roles")
//	private Set<User> users = new HashSet<User>();

	public Role(){}

	public Role(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "Role{" +
				"id=" + id +
				", roleName='" + roleName + '\'' +
				'}';
	}
}
