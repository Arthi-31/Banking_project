package com.example.bankproject.service;
import com.example.bankproject.entity.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bankproject.dao.*;
import java.util.*;
import java.time.*;

@Service
public class AccountService {

	@Autowired
	AccountRepo ar;
	@Autowired
	TransactionRepo tr;
	//account create
	public Account createaccount(Account a)
	{
		return ar.save(a);
	}
	//accounts view
	public List<Account> getallaccounts()
	{
		return ar.findAll();
	}
	
	//particular account view
	public Account getaccountbyid(int id)
	{
		return ar.findById(id).orElse(null);
	}
	
	public Account deposit(int id,double amount)
	{
		Account ac=ar.findById(id).orElse(null);
		if(ac!=null)
		{
			ac.setBalance(ac.getBalance()+amount);
			Transaction trans=new Transaction();
			trans.setTransactiontype("DEPOSIT");
			trans.setAmount(amount);
			trans.setTransactiondate(LocalDateTime.now());
			trans.setAccount(ac);
			tr.save(trans);
			return ar.save(ac);	
		}
		else
		{
			return null;
		}
		
	}
	
	
	public Account withdraw(int id,double amount)
	{
		Account acc=ar.findById(id).orElse(null);
		if(acc!=null && acc.getBalance()>=amount )
		{
			acc.setBalance(acc.getBalance()-amount);
			Transaction tran=new Transaction();
			tran.setTransactiontype("WITHDRAW");
			tran.setAmount(amount);
			tran.setTransactiondate(LocalDateTime.now());
			tran.setAccount(acc);
			tr.save(tran);
			return ar.save(acc);
		}
		else
		{
			return null;
		}
		
	}
	

}
