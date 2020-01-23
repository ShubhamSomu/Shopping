package com.assignment.shopping.cms.model;

import java.util.List;

import org.springframework.data.annotation.Id;

import lombok.Builder;
import lombok.Data;

/*@Document(collection="Filter")
*/@Data
@Builder
public class Filter {

	@Id
	private String id;
	private String name;
	private Boolean isMenuFiter;
	private List<FilterItem> filterItems;
}
