package com.capg.msc.myshoppingcart.service;

import java.util.List;

import com.capg.msc.myshoppingcart.bean.Product;
import com.capg.msc.myshoppingcart.exception.InvalidCostRangeException;
import com.capg.msc.myshoppingcart.exception.InvalidProductException;

public interface ProductService {
	
	public List<Product> getAllProducts();
	public Product saveProduct(Product p) throws InvalidProductException;
	public Product updateProduct(Product p,int id);
	public String deleteProduct(int id);
	public List<Product> getAllProductsByCategory(String category);
	public List<Product> getAllProductsByCategoryAndPrice(String category,int range1,int range2) throws InvalidCostRangeException;
	public List<Product> getAllPRoductsByRating(int rating);
	public List<Product> getAllProductsByBrand(String brandName);
	public List<Product> getProductByName(String pName);
	public Product getProductById(int id);
	

}
