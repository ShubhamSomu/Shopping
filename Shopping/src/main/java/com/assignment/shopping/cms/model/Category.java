package com.assignment.shopping.cms.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Document(collection="Category")
@Data
@Builder
public class Category implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	private String name;
	private String tag;
	private String description;
	private Boolean selected;
	private List<Banner> banners;
	private List<Filter> filters;
}
