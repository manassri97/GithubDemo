package com.capgemini;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.capgemini.productscart.service")
@ComponentScan("com.capgemini.productscart.dao")
@EntityScan("com.capgemini.productscart.bean")
public class ProductsCartManagementManasSrivastavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductsCartManagementManasSrivastavaApplication.class, args);
	}

}
