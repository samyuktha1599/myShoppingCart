package com.capg.msc.myshoppingcart.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.web.context.annotation.ApplicationScope;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



@Entity
@ApiModel(value="Product Bean")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productId;
	
	@ApiModelProperty(name = "Product name",value = "Hold the min 3 char product name",required = true)
	@NotEmpty(message="Product name cannot be null")
	@Size(min=3,max=100,message="Invalid product name")
	private String productName;
	
	@Min(value=1000,message="Product cost cannot be less than 1000")
	@ApiModelProperty(name = "Product cost",value = "Holds Product cost min cost 1000 allowed")
	private int productCost;
	
	@Min(value=1,message="Product rating should be in between 1 and 5")
	@Max(message="Product rating should be in between 1 and 5", value = 5)
	@ApiModelProperty(name = "Product rating",value = "Holds Product rating with value between 1 and 5")
	private int productRating;
	
	@ApiModelProperty(name="Product category",value="Hold the min 3 character category name",required = true)
	@NotEmpty(message="Product category cannot be null")
	@Size(min=3)
	private String category;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	


	public Product(int productId,
			@NotEmpty(message = "Product name cannot be null") @Size(min = 3, max = 100, message = "Invalid product name") String productName,
			@Min(value = 1000, message = "Product cost cannot be less than 1000") int productCost,
			@Min(value = 1, message = "Product rating should be in between 1 and 5") @Max(message = "Product rating should be in between 1 and 5", value = 5) int productRating,
			@NotEmpty(message = "Product category cannot be null") @Size(min = 3) String category) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productCost = productCost;
		this.productRating = productRating;
		this.category = category;
	}






	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductCost() {
		return productCost;
	}

	public void setProductCost(int productCost) {
		this.productCost = productCost;
	}



	public int getProductRating() {
		return productRating;
	}



	public void setProductRating(int productRating) {
		this.productRating = productRating;
	}






	public String getCategory() {
		return category;
	}






	public void setCategory(String category) {
		this.category = category;
	}






	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + productCost;
		result = prime * result + productId;
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + productRating;
		return result;
	}






	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (productCost != other.productCost)
			return false;
		if (productId != other.productId)
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (productRating != other.productRating)
			return false;
		return true;
	}






	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productCost=" + productCost
				+ ", productRating=" + productRating + ", category=" + category + "]";
	}


	

	
	


}
