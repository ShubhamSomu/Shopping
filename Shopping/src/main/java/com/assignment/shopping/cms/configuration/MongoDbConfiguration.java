package com.assignment.shopping.cms.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.convert.DbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

@Configuration
public class MongoDbConfiguration {

	  @Autowired private MongoDbFactory mongoDbFactory;
	  
	  @Autowired private MongoMappingContext mongoMappingContext;
	  
	  @Bean
	  public MappingMongoConverter mappingMongoConverter() {
		  DbRefResolver dbRefResolver = new DefaultDbRefResolver(mongoDbFactory);
		  MappingMongoConverter mappingMongoConverter = new MappingMongoConverter(
				  dbRefResolver, mongoMappingContext);
		  mappingMongoConverter.setTypeMapper(new DefaultMongoTypeMapper(null));
		  return mappingMongoConverter;
	  }
}
