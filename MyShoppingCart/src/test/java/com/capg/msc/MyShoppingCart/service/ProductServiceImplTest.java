package com.capg.msc.MyShoppingCart.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.capg.msc.myshoppingcart.bean.Product;
import com.capg.msc.myshoppingcart.dao.ProductRepository;
import com.capg.msc.myshoppingcart.service.ProductServiceImpl;

@DataJpaTest
public class ProductServiceImplTest {
	
	ProductRepository productRepo;
	private static ProductServiceImpl productService;
	private static AutoCloseable ac;
	
	@BeforeEach
	public void doinit()
	{
		productRepo = mock(ProductRepository.class); // test through approach 2
		productService = new ProductServiceImpl(productRepo); 	// Approach 2
		ac = MockitoAnnotations.openMocks(this);
	}
	
	@AfterEach
	public void doAtEnd()throws Exception
	{
		ac.close();
	}
	
	@Test
	void testSaveProduct() {
		Product input = new Product(101,"HP-123",2000,4,"Laptop");
		Product savedProduct = new Product(101,"HP-123",2000,4,"Laptop");
	
		when(productRepo.save(input)).thenReturn(savedProduct);
		productService.saveProduct(input);
		verify(productRepo).save(input);
		
	}
	
	@Test
	@DisplayName("Test-Get All Products , Args:- No Args to pass")
	void testGetAllProducts() {
		
		
		List<Product> productList = mock(List.class); 
		//when() and 	//thenReturn()
		when(productRepo.findAll()).thenReturn(productList);
		//call the actual method 
		productService.getAllProducts();
		//verify
		verify(productRepo).findAll();
		
	}


}
