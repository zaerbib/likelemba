/**
 * 
 */
package com.business.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.business.demo.entity.category.Category;

/**
 * @author Utilisateur
 *
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
