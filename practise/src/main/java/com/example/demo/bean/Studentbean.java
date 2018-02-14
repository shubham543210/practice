package com.example.demo.bean;

import java.io.Serializable;

import org.springframework.stereotype.Component;


public class Studentbean implements Serializable{

	private static final long serialVersionUID = 1L;

	
	private String name;
	private int rollno;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public int getPercentage() {
		return percentage;
	}
	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}
	private int percentage;
	@Override
	public String toString() {
		return "studentbean [name=" + name + ", rollno=" + rollno + ", percentage=" + percentage + "]";
	}

}
