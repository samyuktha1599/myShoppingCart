package com.capg.msc.myshoppingcart.web;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.msc.myshoppingcart.bean.Product;
import com.capg.msc.myshoppingcart.exception.InvalidCostRangeException;
import com.capg.msc.myshoppingcart.exception.InvalidProductException;
import com.capg.msc.myshoppingcart.exception.InvalidRatingException;
import com.capg.msc.myshoppingcart.service.ProductService;
import com.capg.msc.myshoppingcart.service.ProductServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Validated
@Api(value="Online Gadget Store", description = "Various api works on laptop inventory management")
public class ProductRestController {
	
	
	 Logger log = LoggerFactory.getLogger(ProductRestController.class);

	
	@Autowired
	private ProductService service;

	public ProductRestController() {
		
		log.info("Product Rest Controller- constructor");
	}
	
	@GetMapping("/home")
	public String homeRequest()
	{
		return "Welcome to My Shopping App "+LocalDateTime.now() ;
	}
	
	@ApiOperation(value = "product post mapping" , response = Product.class)
	@PostMapping("/product")
	public Product insertProduct(@RequestBody @Valid Product product) throws InvalidProductException
	{
	
		if(product.getCategory().equals("LAPTOP") && product.getProductCost()<10000 || product.getCategory().equals("CAMERA") && product.getProductCost()<15000)
			throw new InvalidProductException(product.getCategory(), product.getProductCost());
		
		return service.saveProduct(product);
		
		 
	}
	
	@ApiOperation(value = "product Get mapping to fatch all products" , response = List.class)
	@GetMapping("/products")
	public List<Product> getAllProducts()
	{
		return service.getAllProducts();
	}

	@DeleteMapping("/product/{id}")
	public String deleteProduct(@PathVariable int id)
	{
		return service.deleteProduct(id);
		
	}
	
	@PutMapping("/product/{id}")
	public Product updateProduct(@RequestBody Product p,@PathVariable int id)
	{
		return service.updateProduct(p, id);
	}
	
	@GetMapping("/product/{id}")
	public Product getProductById(@PathVariable int id)
	{
		return service.getProductById(id);
		
	}
	
	@GetMapping("/products/{category}")
	public List<Product> getAllProductsByCategory(@PathVariable String category)
	{
		
		return service.getAllProductsByCategory(category);
	}
	
	@GetMapping("/products/{category}/{range1}/{range2}")
	public List<Product> getAllProductsByCategoryAndPrice(@PathVariable String category,
			@PathVariable int range1,@PathVariable int range2) throws InvalidCostRangeException
	{
		if(category.equals("LAPTOP")&& range1<10000)
		{
			throw new InvalidCostRangeException(range1, range2);
		}
		return service.getAllProductsByCategoryAndPrice(category, range1, range2);
	}
	
	@GetMapping("/products/rating/{rating}")
	public List<Product> getAllProductsByRating(@PathVariable int rating) throws InvalidRatingException
	{
		if(rating>5)
		{
			throw new InvalidRatingException(rating);
		}
		return service.getAllPRoductsByRating(rating);
	}
	

	@GetMapping("/product/name/{pName}")
	public List<Product> getAllProductsByName(@PathVariable String pName)
	{
		return service.getProductByName(pName);
	}
	
	
}
