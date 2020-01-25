package com.assignment.shopping.cms.repository;

import java.util.List;
import java.util.Optional;

import com.assignment.shopping.cms.model.Currency;

public interface ICurrencyRepository {
	List<Currency> findAllCurrencies();

	Optional<Currency> findCurrencyById(String id);

	Optional<Currency> saveCurrency(Currency currency);

	Optional<Boolean> deleteCurrency(Currency currency);
	
	Optional<Currency> updateCurrency(Currency currency);
}
