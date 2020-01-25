package com.assignment.shopping.cms.ExceptionHandling;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RequiredVariableNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public RequiredVariableNotFoundException() {
		super();
	}

	public RequiredVariableNotFoundException(String... vars) {
		List<String> message = new ArrayList<String>();
		Arrays.asList(vars).stream().map((va) -> message.add(va + " is required.\n"));
	}

}
