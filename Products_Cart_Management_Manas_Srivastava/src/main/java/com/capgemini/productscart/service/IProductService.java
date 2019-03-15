package com.capgemini.productscart.service;

import java.util.List;

import com.capgemini.productscart.bean.Product;

public interface IProductService {
	public Product createProduct(Product product);
	public Product updateProduct(Product product);
	public String deleteProduct(String id);
	public List<Product> viewAllProducts();
	public Product findProduct(String id);
}
