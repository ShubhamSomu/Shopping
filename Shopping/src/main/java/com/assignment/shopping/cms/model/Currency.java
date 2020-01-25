package com.assignment.shopping.cms.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Builder;
import lombok.Data;

@Document(collection = "Currency")
@Data
@Builder
public class Currency {
	@Id
	private String id;
	private String currencyCode;
	private String factor;
	private String geoCode;
	private List<String> geoId;
	private String name;
	private String value;
	@Builder.Default
	@JsonIgnore
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY) 
	private Boolean isDeleted = false;
}
