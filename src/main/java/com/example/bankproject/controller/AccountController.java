package com.example.bankproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import com.example.bankproject.entity.*;
import com.example.bankproject.service.*;
import java.util.*;
import java.time.*;



@RestController
public class AccountController {

	@Autowired
	AccountService as;
	
	@PostMapping("/createacc")
	public Account get1(@RequestBody Account a)
	{
		
		return as.createaccount(a);
	}
	@GetMapping("/allaccounts")
	public List<Account> get2()
	{
		return as.getallaccounts();
	}
	
	@GetMapping("/partaccounts/{id}")
	public Account get3(@PathVariable int id)
	{
		return as.getaccountbyid(id);
	}
	
	@PutMapping("/deposit/{id}/{amount}")
	public Account get4(@PathVariable int id,@PathVariable double amount)
	{
		return as.deposit(id, amount);
	}
	
	@PutMapping("/withdraw/{id}/{amount}")
	public Account get5(@PathVariable int id,@PathVariable double amount)
	{
		return as.withdraw(id, amount);
	}
	
	
	
	
	
	
	
	
	
	
	

}
