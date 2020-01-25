package com.assignment.shopping.cms.service;

import java.util.List;
import java.util.Optional;

import com.assignment.shopping.cms.model.Category;

public interface CategoryService {

	Optional<Category> retrieveCategoryById(String id);

	Optional<Category> saveCategory(Category category);

	List<Category> retrieveAllCategory();

	Optional<Boolean> deleteCategory(Category category);
}
