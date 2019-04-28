/**
 * 
 */
package com.business.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.business.demo.entity.category.Item;

/**
 * @author Utilisateur
 *
 */
public interface ItemRepository extends JpaRepository<Item, Long> {

}
