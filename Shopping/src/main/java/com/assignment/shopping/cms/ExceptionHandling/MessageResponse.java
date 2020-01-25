package com.assignment.shopping.cms.ExceptionHandling;

import java.time.LocalDateTime;

import com.assignment.shopping.cms.configuration.CustomJsonDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageResponse {
	private String message;
	private String description;
	@JsonSerialize(using = CustomJsonDateSerializer.class)
	private LocalDateTime exceptionTimeStamp;
}
