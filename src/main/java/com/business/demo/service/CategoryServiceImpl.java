/**
 * 
 */
package com.business.demo.service;

import java.util.List;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;

import com.business.demo.entity.category.Category;
import com.business.demo.entity.category.Item;
import com.business.demo.entity.category.Product;
import com.business.demo.repository.CategoryRepository;
import com.business.demo.repository.ItemRepository;
import com.business.demo.repository.ProductRepository;
import com.business.demo.util.StringUtils;

/**
 * @author Utilisateur
 *
 */
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ItemRepository itemRepository;

	@Override
	public Category createCategory(Category category) {
		if(category == null)
			throw new ValidationException(StringUtils.CATEGORY_OBJECT_NULL);
		return categoryRepository.saveAndFlush(category);
	}

	@Override
	public Category findCategory(Long idCategory) {
		if(idCategory == null)
			throw new ValidationException(StringUtils.INVALID_CATEGORY_ID);
		return categoryRepository.findById(idCategory).get();
	}

	@Override
	public Category updateCategory(Category category) {
		if(category == null)
			throw new ValidationException(StringUtils.CATEGORY_OBJECT_NULL);
		return categoryRepository.save(category);
	}

	@Override
	public void deleteCategory(Category category) {
		if(category == null)
			throw new ValidationException(StringUtils.CATEGORY_OBJECT_NULL);
		categoryRepository.delete(category);
	}

	@Override
	public List<Category> findCategory() {
		return categoryRepository.findAll();
	}

	@Override
	public Product createProduct(Product product) {
		if(product == null)
			throw new ValidationException(StringUtils.PRODUCT_OBJECT_NULL);
		return productRepository.save(product);
	}

	@Override
	public Product findProduct(Long idProduct) {
		if(idProduct == null)
			throw new ValidationException(StringUtils.INVALID_PRODUCT_ID);
		return productRepository.findById(idProduct).get();
	}

	@Override
	public Product updateProduct(Product product) {
		if(product == null)
			throw new ValidationException(StringUtils.PRODUCT_OBJECT_NULL);
		return null;
	}

	@Override
	public void deleteProduct(Product product) {
		if(product == null)
			throw new ValidationException(StringUtils.PRODUCT_OBJECT_NULL);
		productRepository.delete(product);
	}

	@Override
	public List<Product> findProduct() {
		return productRepository.findAll();
	}

	@Override
	public Item createItem(Item item) {
		if(item == null)
			throw new ValidationException(StringUtils.ITEM_OBJECT_NULL);
		return itemRepository.saveAndFlush(item);
	}

	@Override
	public Item findItem(Long idItem) {
		if(idItem == null)
			throw new ValidationException(StringUtils.INVALID_ITEM_ID);
		return itemRepository.findById(idItem).get();
	}

	@Override
	public Item updateItem(Item item) {
		if(item == null)
			throw new ValidationException(StringUtils.ITEM_OBJECT_NULL);
		return itemRepository.save(item);
	}

	@Override
	public void deleteItem(Item item) {
		if(item == null)
			throw new ValidationException(StringUtils.ITEM_OBJECT_NULL);
		itemRepository.delete(item);
	}

	@Override
	public List<Item> findItem() {
		return itemRepository.findAll();
	}

	@Override
	public List<Item> searchItem(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
