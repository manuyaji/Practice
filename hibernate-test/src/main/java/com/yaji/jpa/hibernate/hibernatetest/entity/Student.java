package com.yaji.jpa.hibernate.hibernatetest.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import enums.SomeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=true)
@Table(name="student")
public class Student extends Person{
	
	/*@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;*/
	
	@Column(name="roll_num")
	private String rollNum;
	
	@Column(name="some_enum")
	private SomeEnum someEnum;
	
	public Student(){}
	
	public Student(String rollNum, String name, String address, Date dateOfBirth, SomeEnum someEnum){
		setAddress(address);
		setDateOfBirth(dateOfBirth);
		setName(name);
		this.rollNum = rollNum;
		this.someEnum = someEnum;
	}
}
