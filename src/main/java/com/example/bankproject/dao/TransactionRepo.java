package com.example.bankproject.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bankproject.entity.*;
public interface TransactionRepo extends JpaRepository<Transaction,Integer>{

}
