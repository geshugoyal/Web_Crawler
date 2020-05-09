package com.webgeshu.crawlergeshu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication

public class CrawlerggApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrawlerggApplication.class, args);
		
	}
}
