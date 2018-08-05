package com.cg.bean;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Account {
	@Id
	@GeneratedValue
	private int id;	
	private String phoneNumber;
	private String name;
	private String email;
	private double balance;
	private Date date;
	
	
	public void setphoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Account(String phoneNumber, String name, String email,
			double balance, Date date) {
		super();
		this.phoneNumber = phoneNumber;
		this.name = name;
		this.email = email;
		this.balance = balance;
		this.date = date;
	}
	public Account() {
		super();
	}
	
	

}
