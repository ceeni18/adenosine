package com.web.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;

@Configuration
public class SpringMongoConfig {
	private static Logger logger = LoggerFactory.getLogger(
			SpringMongoConfig.class);

	public @Bean
	MongoDbFactory mongoDbFactory() throws Exception {
		logger.debug("Connecting to MongoDB at "+
				Constants.DATABASE_HOSTNAME+":"+Constants.DATABASE_PORT);
		logger.debug("Using Database "+Constants.DATABASE_NAME);
		logger.debug("with Username :: "+ Constants.DATABASE_USERNAME+" and " +
				"password :: "+Constants.DATABASE_PASSWORD);

		return new SimpleMongoDbFactory(
				new MongoClient(
						Constants.DATABASE_HOSTNAME,
						Constants.DATABASE_PORT
						),
				Constants.DATABASE_NAME,
				new UserCredentials(
						Constants.DATABASE_USERNAME,
						Constants.DATABASE_PASSWORD
						));
	}

	public @Bean
	MongoTemplate mongoTemplate(){
		MongoDbFactory mongoDbFactory = null;
		MongoTemplate mongoTemplate = null;
		try {
			mongoDbFactory = mongoDbFactory();
			mongoTemplate = new MongoTemplate(mongoDbFactory);
		}catch (Exception e){
			logger.error("Database exception :: " + e);
		}
		return mongoTemplate;
	}
}
