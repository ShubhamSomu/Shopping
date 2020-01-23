package com.assignment.shopping.cms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.assignment.shopping.cms.model.Category;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository{

	@Autowired
	MongoTemplate mongoTemplate;
	
	@Override
	public Optional<Category> retrieveById(String id) {
		Category category = mongoTemplate.findById(id, Category.class);
		return Optional.of(category);
	}

	@Override
	public List <Category> retrieveAllCategory() {
			List <Category> allCategory = mongoTemplate.findAll(Category.class);
		return allCategory;
	}

	@Override
	public Optional<Category> saveCategory(Category category) {
			Category savedCategory = mongoTemplate.save(category);
		return Optional.of(savedCategory);
	}

}
