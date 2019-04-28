/**
 * 
 */
package com.business.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.business.demo.entity.category.Category;
import com.business.demo.entity.category.Item;
import com.business.demo.entity.category.Product;



/**
 * @author Utilisateur
 *
 */
@Service
public interface CategoryService  {
	// Catégorie
	public Category createCategory(Category category);
	public Category findCategory(Long idCategory);
	public Category updateCategory(Category Category);
	public void deleteCategory(Category Category);
	public List<Category> findCategory();
	
	// Produit
	public Product createProduct(Product Product);
	public Product findProduct(Long idProduct);
	public Product updateProduct(Product Product);
	public void deleteProduct(Product Product);
	public List<Product> findProduct();
	
	// Item
	public Item createItem(Item Item);
	public Item findItem(Long idItem);
	public Item updateItem(Item Item);
	public void deleteItem(Item Item);
	public List<Item> findItem();
	
	// recherche
	public List<Item> searchItem(String keyword);
}
