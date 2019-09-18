package com.articleSpringBoot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ArticleSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArticleSpringBootApplication.class, args);
	}

}
