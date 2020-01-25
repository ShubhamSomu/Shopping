package com.assignment.shopping.cms.mocker;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.assignment.shopping.cms.model.Currency;
import com.assignment.shopping.cms.repository.CurrencyRepository;

@Component
@Order(2)
public class CurrencyMocker implements CommandLineRunner {

	@Autowired
	CurrencyRepository currencyRepository;
	
	@Override
	public void run(String... args) throws Exception {
		Currency currency1 = this.getFakeCurrency();
		currencyRepository.saveCurrency(currency1);
		
	}
	
	private Currency getFakeCurrency() {
		List<String> geoIdList = new ArrayList<String>();
		geoIdList.add("Lorem");
		Currency currency = Currency.builder().currencyCode("Lorem")
		.factor("Lorem")
		.geoCode("Lorem")
		.geoId(geoIdList)
		.name("Lorem")
		.value("Lorem")
		.build();
		return currency;
	}

}
