package com.assignment.shopping.cms.model.restcontroller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.assignment.shopping.cms.ExceptionHandling.RequiredVariableNotFoundException;
import com.assignment.shopping.cms.model.Currency;
import com.assignment.shopping.cms.service.CurrencyService;

@RestController
@RequestMapping("/currency")
public class CurrencyController {

	@Autowired
	private CurrencyService currencyService;

	@GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAllCurrencies() {
		List<Currency> allCurrencies = currencyService.findAllCurrencies();
		if (allCurrencies == null || allCurrencies.size() <= 0) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok().body(allCurrencies);
		}
	}

	@GetMapping(path = "/id/{id}")
	public ResponseEntity<?> getCurrencyById(@PathVariable String id) {
		Optional<Currency> currency = currencyService.findCurrencyById(id);
		if (currency.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok().body(currency.get());
		}
	}

	@PostMapping()
	public ResponseEntity<?> saveCurrency(@RequestBody Currency currency) {
		Optional<Currency> savedCurrencyOpt = currencyService.saveCurrency(currency);
		if (savedCurrencyOpt.isEmpty())
			return ResponseEntity.badRequest().build(); // show orignal error
		else {
			Currency savedCurrency = savedCurrencyOpt.get();
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id/{id}")
					.buildAndExpand(savedCurrency.getId()).toUri();
			return ResponseEntity.created(uri).build();
		}
	}

	@DeleteMapping("/id/{id}")
	public ResponseEntity<?> deleteCurrencyById(@PathVariable String id, WebRequest request) throws Exception {
		Optional<Currency> currencyToDel = currencyService.findCurrencyById(id);
		if (currencyToDel.isEmpty()) {
			return ResponseEntity.ok().build();
		} else {
			Optional<Boolean> isDeletedOpt = currencyService.deleteCurrency(currencyToDel.get());
			if (isDeletedOpt.isEmpty() || !isDeletedOpt.get()) {
				return ResponseEntity.badRequest().build();
			} else {
				return ResponseEntity.ok().build();
			}
		}
	}

	@PutMapping("/id/{id}")
	public ResponseEntity<?> updateCurrencyById(@PathVariable String id, @RequestBody Currency updatedCurrency)
			throws RequiredVariableNotFoundException {

		return null;
	}

}
