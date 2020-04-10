package com.TCS_POC.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.TCS_POC.Model.Account_transactions;


@Repository
public interface AccountRepo extends JpaRepository<Account_transactions, Long> {
	
	
	@Query("Select acc FROM Account_transactions acc WHERE acc.from_user_id=:userId")
	List<Account_transactions>getAccountTransactionsByUserId(@Param("userId")long userId);
	
}
