package com.capg.msc.myshoppingcart.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import com.capg.msc.myshoppingcart.bean.Product;

public class CustomProductRepositoryImpl implements CustomProductRepository{
	
	@Autowired
	EntityManager entityManager; // Session of Hibernate
	
	
	@Override
	public List<Product> getProductByCategory(String proudctCategory) {
		
		Query q = entityManager.createQuery("from Product where category=:productCategory");
		q.setParameter("productCategory", proudctCategory);
		return q.getResultList();
	}


	@Override
	public List<Product> getProductByCategoryAndPrice(String proudctCategory, int range1, int range2) {
		Query q = entityManager.createQuery("from Product where category=:productCategory "
				+ "and productCost BETWEEN :range1 and :range2");
		q.setParameter("productCategory", proudctCategory);
		q.setParameter("range1", range1);
		q.setParameter("range2", range2);
		
		return q.getResultList();
	}


	@Override
	public List<Product> getProductByRating(int rating) {
		Query q=entityManager.createQuery("from Product where productRating=: pRating");
		q.setParameter("pRating", rating);
		
		return q.getResultList();
	}


	@Override
	public List<Product> getProductByName(String pName) {
		Query q=entityManager.createQuery("from Product where productName =:name");
		q.setParameter("name",pName);
		return q.getResultList();
	}


	@Override
	public List<Product> getProductByBrand(String brandName) {
		// TODO Auto-generated method stub
		return null;
	}
	
//	@Override
//	public List<Product> getProductByBrand(String brandName) {
//		Query q=entityManager.createQuery("from Product where productName like :name%");
//		q.setParameter("name",brandName);
//		return q.getResultList();
//	}
//	
	
	
	

}
