package com.TCS_POC.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TCS_POC.Model.Account_transactions;
import com.TCS_POC.services.AccountServices;

@RestController
@RequestMapping("api")
public class TransactionController {
	@Autowired
	AccountServices accountServices;
	
	
	@RequestMapping("sendAmounToAccount")
	public  ResponseEntity<?>  sendAmount(@RequestBody HashMap<String,String> request) {
		try {
			
//			user_id
//			amount
//			to_acc_no
			
			List<Account_transactions> tmp = accountServices.startTransaction(request);
			return ResponseEntity.ok(tmp);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(new Response(e.getMessage()));
		}
	}
	
	
	@RequestMapping("getAllTransactionByUserId")
	public  ResponseEntity<?>  getAllTransactions(@RequestBody HashMap<String,String> request) {
		try {
			List<Account_transactions> tmp = accountServices.getAllTransactionByUserId(Long.parseLong(request.get("userId")));
			return ResponseEntity.ok(tmp);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(new Response(e.getMessage()));
		}
	}
}
