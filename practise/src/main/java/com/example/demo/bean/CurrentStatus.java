package com.example.demo.bean;

import java.io.Serializable;

public class CurrentStatus implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String name;
	private String description;
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
		return "CurrentStatus [name=" + name + ", description=" + description + "]";
	}
	

}
