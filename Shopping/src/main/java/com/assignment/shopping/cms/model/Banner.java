package com.assignment.shopping.cms.model;

import org.springframework.data.annotation.Id;

import lombok.Builder;
import lombok.Data;


/*@Document(collection="Banner")*/
@Data
@Builder
public class Banner {
	@Id
 private String id;
	private String imageUrl;
	private String linkUrl;
	private String html;
	private Coordinates coordinate;
	private Integer orignalWidth;
}
