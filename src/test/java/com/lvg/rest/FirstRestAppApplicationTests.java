package com.lvg.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.internal.stubbing.answers.DoesNothing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.lvg.rest.entity.Product;
import com.lvg.rest.repository.ProductRepository;
import com.lvg.rest.service.ProductService;	

import jakarta.annotation.security.RunAs;

//@RunAs(SpringRunner.class)
@SpringBootTest
class FirstRestAppApplicationTests {

	@Autowired
	ProductService productService;
	
	@MockBean
	ProductRepository productRepository;
	
	@Test
	void getAllProductsTest() {
		List<Product> pList = Arrays.asList(new Product(7001, "Lux", "Soap", 50, 2), new Product(7002, "Axe", "Deodrant", 199, 1));
		when(productRepository.findAll()).thenReturn(pList);
		assertEquals(2, productService.getAllProducts().size());
	}

	@Test
	void insertOrModifyTest() {
		Product p = new Product(7002, "Close Up", "Tooth Paste", 15, 150);
		when(productRepository.save(p)).thenReturn(p);
		assertEquals(true, productService.insertOrModifyProduct(p));
	}
	
}
