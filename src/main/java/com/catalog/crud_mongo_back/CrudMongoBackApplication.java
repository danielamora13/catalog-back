package com.catalog.crud_mongo_back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.catalog.crud_mongo_back.CRUD.repository")
public class CrudMongoBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudMongoBackApplication.class, args);
	}

}
