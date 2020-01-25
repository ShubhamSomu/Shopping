package com.assignment.shopping.cms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.assignment.shopping.cms.model.Category;

@Repository
public interface CategoryRepository/* extends MongoRepository<Category, String> */ {

	Optional<Category> retrieveById(String id);

	List<Category> retrieveAllCategory();

	Optional<Category> saveCategory(Category category);

	Optional<Boolean> deleteCategory(Category category);
}
