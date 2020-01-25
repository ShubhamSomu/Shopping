package com.assignment.shopping.cms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.assignment.shopping.cms.model.Category;
import com.assignment.shopping.cms.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	MongoTemplate mongoTemplate;

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Optional<Category> retrieveCategoryById(String id) {
		return categoryRepository.retrieveById(id);
	}

	@Override
	public Optional<Category> saveCategory(Category category) {
		Optional<Category> categoryOpt = categoryRepository.saveCategory(category);
		return categoryOpt;
	}

	@Override
	public List<Category> retrieveAllCategory() {
		return categoryRepository.retrieveAllCategory();
	}

	@Override
	public Optional<Boolean> deleteCategory(Category category) {
		return categoryRepository.deleteCategory(category);
	}

}
