/**
 * 
 */
package com.business.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.business.demo.entity.category.Category;

/**
 * @author Utilisateur
 *
 */

@Component
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
