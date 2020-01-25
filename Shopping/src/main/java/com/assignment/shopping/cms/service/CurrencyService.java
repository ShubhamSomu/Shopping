package com.assignment.shopping.cms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.MissingServletRequestParameterException;

import com.assignment.shopping.cms.ExceptionHandling.ResourceNotFoundException;
import com.assignment.shopping.cms.model.Currency;
import com.assignment.shopping.cms.repository.CurrencyRepository;

public class CurrencyService implements ICurrencyService {

	@Autowired
	CurrencyRepository currencyRepository;

	@Override
	public List<Currency> findAllCurrencies() {
		return currencyRepository.findAllCurrencies();
	}

	@Override
	public Optional<Currency> findCurrencyById(String id) {
		return currencyRepository.findCurrencyById(id);
	}

	@Override
	public Optional<Currency> saveCurrency(Currency currency) {
		return currencyRepository.saveCurrency(currency);
	}

	@Override
	public Optional<Boolean> deleteCurrency(Currency currency) {
		return currencyRepository.deleteCurrency(currency);
	}

	@Override
	public Optional<Currency> updateCurrency(Currency currency) throws Exception {
		if (currency == null || currency.getId() == null || currency.getId().isEmpty()) {
			throw new MissingServletRequestParameterException("id", "String");
		} else {
			if (this.findCurrencyById(currency.getId()).isPresent()) {
				return currencyRepository.updateCurrency(currency);
			} else {
				throw new ResourceNotFoundException("Currency");
			}
		}

	}

}
