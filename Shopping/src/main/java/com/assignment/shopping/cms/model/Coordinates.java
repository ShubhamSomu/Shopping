package com.assignment.shopping.cms.model;

import org.springframework.data.annotation.Id;

import lombok.Builder;
import lombok.Data;

/*@Document(collection="Coordinates")
*/@Data
@Builder
public class Coordinates {
	@Id
	private String id;
	private Integer items;
}
