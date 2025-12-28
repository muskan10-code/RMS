package com.manav.ncu.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CascadeType;

import javax.persistence.JoinColumn;

@Entity
@Table(name="role_mst")
public class Role {
@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + ", rights=" + rights + "]";
	}
public Role(int roleId, String roleName, List<Rights> rights) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.rights = rights;
	}
public Role() {}
public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public List<Rights> getRights() {
		return rights;
	}
	public void setRights(List<Rights> rights) {
		this.rights = rights;
	}
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name="role_id")
public int roleId;
@Column(name="role_name")
private String roleName;
@ManyToMany(targetEntity=Rights.class)
@JoinTable(name="role_right_mapping",
joinColumns = @JoinColumn(name="role_id",referencedColumnName = "role_id"),
inverseJoinColumns = @JoinColumn(name="right_id",referencedColumnName = "right_id"))
private List<Rights> rights;

}
