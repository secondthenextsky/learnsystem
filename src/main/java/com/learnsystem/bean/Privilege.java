package com.learnsystem.bean;

public class Privilege {
	
	private int id;
	/**
	 * 权限名
	 */
	private String name;
	/**
	 * 权限描述
	 */
	private String description;
	
	public Privilege() {}
	
	public Privilege(String name) {
		this.name = name;
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
	
	@Override
	public String toString() {
		return this.getId()+"";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Privilege privilege = (Privilege) o;

		return id == privilege.id;
	}

	@Override
	public int hashCode() {
		return id;
	}
}
