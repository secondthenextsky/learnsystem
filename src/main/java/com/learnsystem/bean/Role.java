package com.learnsystem.bean;

import java.util.LinkedHashSet;
import java.util.Set;

public class Role {

	private int id;
	/**
	 * 角色名
	 */
	private String name;
	/**
	 * 角色描述
	 */
	private String description;
	/**
	 * 角色拥有的权限集合
	 */
	private Set<Privilege> privileges = new LinkedHashSet<Privilege>();
	
	public String getPrivilegeStr(){
		return privileges.toString();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public Set<Privilege> getPrivileges() {
		return privileges;
	}

	
	@Override
	public String toString() {
		return this.getId()+"";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Role role = (Role) o;

		return id == role.id;
	}

	@Override
	public int hashCode() {
		return id;
	}
}
