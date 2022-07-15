package com.retailer.transactions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.retailer.transactions.repositories")
@SpringBootApplication
public class RetailerTransactionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetailerTransactionsApplication.class, args);
	}

}
