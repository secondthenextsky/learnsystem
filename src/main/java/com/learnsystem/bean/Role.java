package com.learnsystem.bean;

import java.util.LinkedHashSet;
import java.util.Set;

public class Role {

	private String id;
	private String name;
	private String description;
	private Set<Privilege> privileges = new LinkedHashSet<Privilege>();
	
	public String getPrivilegeStr(){
		return privileges.toString();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
//	public void setPrivileges(Set<Privilege> privileges) { 设置的话会清空原因的权限
//		this.privileges = privileges;
//	}
	
	
	@Override
	public String toString() {
		return this.getId();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
