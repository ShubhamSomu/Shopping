package com.assignment.shopping.cms.model;

import org.springframework.data.annotation.Id;

import lombok.Builder;
import lombok.Data;

/*@Document(collection="FilterItems")
*/@Data
@Builder
public class FilterItem {

	@Id
	private String id;
	private String name;
	private String selected;
	private String hasChildren;
	private String type;
}
