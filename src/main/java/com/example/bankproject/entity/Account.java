package com.example.bankproject.entity;
import jakarta.persistence.*;

@Entity
public class Account {
	    @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
		int id;
	    String accno;
	    String acctype;
	    double balance;
	    @OneToOne(cascade=CascadeType.ALL)
	    @JoinColumn(name="customer_id")
	    Customer cust;
		public Account() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Account(String accno, String acctype, double balance, Customer cust) {
			super();
			this.accno = accno;
			this.acctype = acctype;
			this.balance = balance;
			this.cust = cust;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getAccno() {
			return accno;
		}
		public void setAccno(String accno) {
			this.accno = accno;
		}
		public String getAcctype() {
			return acctype;
		}
		public void setAcctype(String acctype) {
			this.acctype = acctype;
		}
		public double getBalance() {
			return balance;
		}
		public void setBalance(double balance) {
			this.balance = balance;
		}
		public Customer getCust() {
			return cust;
		}
		public void setCust(Customer cust) {
			this.cust = cust;
		}
	    
	    
	    
	
	
	
}
