package com.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;

@Configuration
public class SpringMongoConfig {

	public @Bean
	MongoDbFactory mongoDbFactory() throws Exception {
		return new SimpleMongoDbFactory(new MongoClient(), "users");
		//return new SimpleMongoDbFactory(new MongoClient("http://52.73.142.19/", 27017), "adenosine", new UserCredentials("adenosine", "abcdefghijkl"));
	}
	
	public @Bean
	MongoTemplate mongoTemplate() throws Exception {	
		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());			
		return mongoTemplate;
	}
}
