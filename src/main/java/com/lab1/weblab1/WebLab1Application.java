package com.lab1.weblab1;

import com.lab1.weblab1.models.ProductModel;
import com.lab1.weblab1.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.cache.annotation.EnableCaching;


@SpringBootApplication
@EnableCaching
public class WebLab1Application {

	public static void main(String[] args) {
		SpringApplication.run(WebLab1Application.class, args);
	}

	@Bean
	public CommandLineRunner initProducts(ProductRepository productRepository) {
		return args -> {
			ProductModel productOne = new ProductModel();
			productOne.setId(1L); 
			productOne.setName("ProductOne");
			productRepository.save(productOne);

			ProductModel productTwo = new ProductModel();
			productTwo.setId(2L);
			productTwo.setName("ProductTwo");
			productRepository.save(productTwo);
		};
	}
}
