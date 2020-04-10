package com.TCS_POC.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//
@Entity
@Table(name = "account_transactions")
public class Account_transactions {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	long from_user_id;
	long to_acc_no;
	double amount;
	int status;
	@Column(updatable=false, insertable=false)
	String date;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public long getFrom_user_id() {
		return from_user_id;
	}
	public void setFrom_user_id(long from_user_id) {
		this.from_user_id = from_user_id;
	}
	public long getTo_acc_no() {
		return to_acc_no;
	}
	public void setTo_acc_no(long to_acc_no) {
		this.to_acc_no = to_acc_no;
	}
}
