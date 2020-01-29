package com.assignment.shopping.cms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.assignment.shopping.cms.model.Currency;
import com.mongodb.client.result.UpdateResult;

@Repository
public class CurrencyRepository implements ICurrencyRepository {

	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public List<Currency> findAllCurrencies() {
		Query query = new Query().addCriteria(Criteria.where("isDeleted").is(false));
		List<Currency> allCurrencies = mongoTemplate.find(query, Currency.class);
		return allCurrencies;
	}

	@Override
	public Optional<Currency> findCurrencyById(String id) {
		Query query = new Query().addCriteria(Criteria.where("isDeleted").is(false).and("id").is(id));
		List<Currency> find = mongoTemplate.find(query, Currency.class);
		if (find == null || find.size() <= 0 || find.get(0) == null)
			return Optional.ofNullable(null);
		else {
			Optional<Currency> currency = Optional.of(find.get(0));
			return currency;
		}

	}

	@Override
	public Optional<Currency> saveCurrency(Currency currency) {
		Optional<Currency> savedCurrencyOpt = Optional.of(mongoTemplate.save(currency));
		return savedCurrencyOpt;
	}

	@Override
	public Optional<Boolean> deleteCurrency(Currency currency) {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(currency.getId()));

		Update update = new Update();
		update.set("isDeleted", true);
		UpdateResult updateFirst = mongoTemplate.updateFirst(query, update, Currency.class);

		Optional<Boolean> deletedCurrency = Optional.of(updateFirst.wasAcknowledged());
		return deletedCurrency;
	}

	@Override
	public Optional<Currency> updateCurrency(Currency currency) {
			return Optional.of(mongoTemplate.save(currency));
	}

}
