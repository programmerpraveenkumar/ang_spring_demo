package com.TCS_POC.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.TCS_POC.Model.User;


@Repository
public interface UserRepo extends JpaRepository<User, Long> {
	@Query("select user from User user where user.email=:email and user.password=:pwd")
	Optional<User> findByLogin(@Param("email")String email,@Param("pwd")String pwd);
	
}
