package com.TCS_POC.services;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TCS_POC.Model.Account_transactions;
import com.TCS_POC.repository.AccountRepo;

@Service
public class AccountServices {

	@Autowired
	AccountRepo accountRepo; 
	public List<Account_transactions> getAllTransactionByUserId(long userId){
			return accountRepo.getAccountTransactionsByUserId(userId);
	}
	public List<Account_transactions> startTransaction(HashMap<String,String> account){
		long userId = Long.parseLong(account.get("userId"));
		Account_transactions acc_trans = new Account_transactions();
		acc_trans.setAmount(Double.parseDouble(account.get("amount")));
		acc_trans.setTo_acc_no(Long.parseLong(account.get("to_acc_no")));
		acc_trans.setStatus(1);
		acc_trans.setFrom_user_id(userId);
		accountRepo.save(acc_trans);
		return this.getAllTransactionByUserId(userId);
	}
}
