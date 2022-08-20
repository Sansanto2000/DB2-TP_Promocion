package com.mitocode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableMongoRepositories("com.mitocode.repo.mongo")
@EnableJpaRepositories(basePackages = "com.mitocode.repo.postgre")
@EnableTransactionManagement
public class DemoDatabasesApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoDatabasesApplication.class, args);
	}

}
