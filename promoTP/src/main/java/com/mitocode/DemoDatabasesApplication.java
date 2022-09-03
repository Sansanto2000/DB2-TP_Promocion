package com.mitocode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.mitocode.repo.mongo")
@EnableJpaRepositories(basePackages = "com.mitocode.repo.postgre")
@EnableElasticsearchRepositories(basePackages = "com.mitocode.repo.elastic")
@EnableTransactionManagement
public class DemoDatabasesApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoDatabasesApplication.class, args);
	}

}
