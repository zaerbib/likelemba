package com.business.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import com.business.demo.entity.User;

@Component
public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query("select u from User u where u.login = :login")
	public Optional<User> findUserWithName(String login);
}
