package com.capgemini.productscart.dao;

import java.util.List;

import com.capgemini.productscart.bean.Product;

public interface IProductRepo {
	public Product save(Product product);
	public Product update(Product product);
	public boolean delete(String id);
	public List<Product> findAll();
	public Product find(String id);
}
