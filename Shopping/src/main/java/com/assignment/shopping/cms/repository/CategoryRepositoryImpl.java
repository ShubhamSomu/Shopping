package com.assignment.shopping.cms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.assignment.shopping.cms.model.Category;
import com.mongodb.client.result.UpdateResult;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public Optional<Category> retrieveById(String id) {
		Query query = new Query().addCriteria(Criteria.where("isDeleted").is(false));
		List<Category> find = mongoTemplate.find(query, Category.class);
		if (find == null || find.size() <= 0 || find.get(0) == null)
			return Optional.of(null);
		else {
			Optional<Category> currency = Optional.of(find.get(0));
			return currency;
		}
	}

	@Override
	public List<Category> retrieveAllCategory() {
		Query query = new Query().addCriteria(Criteria.where("isDeleted").is(false));
		List<Category> allCategory = mongoTemplate.find(query, Category.class);
		return allCategory;
	}

	@Override
	public Optional<Category> saveCategory(Category category) {
		Category savedCategory = mongoTemplate.save(category);
		return Optional.of(savedCategory);
	}

	@Override
	public Optional<Boolean> deleteCategory(Category category) {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(category.getId()));

		Update update = new Update();
		update.set("isDeleted", true);
		UpdateResult updateFirst = mongoTemplate.updateFirst(query, update, Category.class);

		Optional<Boolean> deletedCurrency = Optional.of(updateFirst.wasAcknowledged());
		return deletedCurrency;
	}

}
