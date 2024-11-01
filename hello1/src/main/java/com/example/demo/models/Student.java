package com.example.demo.models;

import java.util.Optional;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Student {
	@jakarta.persistence.Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Integer Id;
	private String name;
	private int marks;
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public Optional<Student> findById1(Integer id2) {
		// TODO Auto-generated method stub
		return null;
	}
	}
