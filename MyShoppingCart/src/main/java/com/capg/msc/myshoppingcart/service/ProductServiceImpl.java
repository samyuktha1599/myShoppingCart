package com.capg.msc.myshoppingcart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.capg.msc.myshoppingcart.bean.Product;
import com.capg.msc.myshoppingcart.dao.ProductRepository;
import com.capg.msc.myshoppingcart.exception.InvalidCostRangeException;
import com.capg.msc.myshoppingcart.exception.InvalidProductException;

@Service
public class ProductServiceImpl implements ProductService{
	

	@Autowired
	private ProductRepository repo;
	

	public ProductServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public ProductServiceImpl(ProductRepository repo) {
		super();
		this.repo = repo;
	}



	@Override
	public List<Product> getAllProducts() {
		
		return repo.findAll();
	}

	@Override
	public Product saveProduct(Product p) {
		repo.save(p);
		return p;
	}
	
	


	@Override
	public String deleteProduct(int id) {
		repo.deleteById(id);
		return "Deleted";
	}

	@Override
	public Product updateProduct(Product p,int id) {
		Optional<Product> toUpdate=repo.findById(id);
		
		if(toUpdate.isPresent())
		{
			Product product=toUpdate.get();
			product.setProductName(p.getProductName());
			product.setProductCost(p.getProductCost());
			product.setProductRating(p.getProductRating());
			product.setCategory(p.getCategory());
			return repo.save(product);
		}
		return null;
	}

	@Override
	public Product getProductById(int id) 
	{
		return repo.findById(id).get();
		
	}
	
	@Override
	public List<Product> getAllProductsByCategory(String category) {
		
		return repo.getProductByCategory(category);
	}

	@Override
	public List<Product> getAllProductsByCategoryAndPrice(String category, int range1, int range2) throws InvalidCostRangeException{
		
		return repo.getProductByCategoryAndPrice(category, range1, range2);
	}
	
	@Override
	public List<Product> getAllPRoductsByRating(int rating)
	{
		return repo.getProductByRating(rating);
		
	}

	@Override
	public List<Product> getAllProductsByBrand(String brandName) {
		
		return repo.getProductByBrand(brandName);
	}

	@Override
	public List<Product> getProductByName(String pName) {
		
		return repo.getProductByName(pName);
	}
	
	
	
	
}
