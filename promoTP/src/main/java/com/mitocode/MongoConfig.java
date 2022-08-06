package com.mitocode;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import com.mongodb.MongoClientSettings;
import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.core.convert.converter.Converter;

@Configuration
@EnableMongoRepositories(basePackages = "com.mitocode.repo.mongo")
public class MongoConfig {
	
	@Autowired
	private Environment env;

	private final List<Converter<?, ?>> converters = new ArrayList<Converter<?, ?>>();

	//@Override
	protected String getDatabaseName() {
		return "test";
	}

	//@Override
	public MongoClient mongoClient() {
		final ConnectionString connectionString = new ConnectionString("mongodb://root:root@localhost:27017");
		final MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
				.applyConnectionString(connectionString)
				.build();
		return MongoClients.create(mongoClientSettings);
	}

	//@Override
	public Collection<String> getMappingBasePackages() {
		return Collections.singleton("com.mitocode.model");
	}

}
