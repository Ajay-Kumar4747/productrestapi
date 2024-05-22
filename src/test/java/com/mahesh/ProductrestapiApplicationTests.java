package com.mahesh;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.mahesh.entities.Product;

@SpringBootTest
class ProductrestapiApplicationTests {

	@Value("${product.service.url}")
	private String baseURL;
	@Test
	void testGetProduct() {
		System.out.println(baseURL);
		RestTemplate rst=new RestTemplate();
		Product prod=rst.getForObject(baseURL+"1",Product.class);
		System.out.println(prod.getId());
		System.out.println(prod.getName());
	}

	@Test
	void createProduct() {

		RestTemplate rst=new RestTemplate();
		Product product=new Product();
		product.setName("Iqoo");
		product.setPrice(250);
		product.setDescription1("avg company with good specs");
		Product ptd=rst.postForObject(baseURL, product,Product.class);
		System.out.println(ptd.getId());
		System.out.println(ptd.getName());
		System.out.println(ptd.getPrice());
		System.out.println(ptd.getDescription1());
		
	}
	
	@Test
	void updateProduct() {

		RestTemplate rst=new RestTemplate();
		Product prod=rst.getForObject(baseURL+"1",Product.class);
		System.out.println(prod.getId());
		System.out.println(prod.getName());
		
		prod.setPrice(800);
		rst.put(baseURL, prod);
		
	}
}
