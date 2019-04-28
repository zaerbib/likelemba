/**
 * 
 */
package com.business.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import com.business.demo.entity.User;
import com.business.demo.entity.category.Item;

/**
 * @author Utilisateur
 *
 */

@Component
public interface ItemRepository extends JpaRepository<Item, Long> {
	@Query("select i from Item i where u.login = :login")
	public Optional<User> findUserWithName(String login);
}
