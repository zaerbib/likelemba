/**
 * 
 */
package com.business.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.business.demo.entity.category.Item;

/**
 * @author Utilisateur
 *
 */

@Component
public interface ItemRepository extends JpaRepository<Item, Long> {
	List<Item> findByNameIgnoreCase(String firstName);
}
