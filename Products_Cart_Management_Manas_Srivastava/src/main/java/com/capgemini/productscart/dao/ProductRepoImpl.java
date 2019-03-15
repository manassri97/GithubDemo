package com.capgemini.productscart.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.capgemini.productscart.bean.Product;

@Repository
public class ProductRepoImpl implements IProductRepo{

	@PersistenceContext
	EntityManager entityManager;
	
	/*(non-javadoc)
	*add product into database
	*/
	@Transactional
	@Override
	public Product save(Product product) {
		Product product_ref = entityManager.find(Product.class, product.getId());
		if(product_ref==null)
		{
			entityManager.persist(product);
			return product;
		}
		else
		{
			return null;
		}
	}

	/*(non-javadoc)
	*update product details in existing product
	*/
	@Transactional
	@Override
	public Product update(Product product) {
		Product product_ref = entityManager.find(Product.class, product.getId());
		if(product_ref==null) {
			return null;
		}
		else
		{
			product_ref.setName(product.getName());
			product_ref.setModel(product.getModel());
			product_ref.setPrice(product.getPrice());
			entityManager.merge(product_ref);
			return product;
		}
	}

	/*(non-javadoc)
	*delete product from database
	**/
	@Transactional
	@Override
	public boolean delete(String id) {
		Product product_ref = entityManager.find(Product.class, id);
		if(product_ref==null) 
		{
			return false;
		}
		else
		{
			entityManager.remove(product_ref);
			return true;
		}
	}

	/*(non-javadoc)
	*to retrieve all products
	*/
	@Transactional
	@Override
	public List<Product> findAll() {
		Query query = entityManager.createQuery("select product from Product product", Product.class);
		List<Product> list = query.getResultList();
		return list;
	}

	/*(non-javadoc)
	*to retrieve single product 
	*/
	@Transactional
	@Override
	public Product find(String id) {
		Product product_ref = entityManager.find(Product.class, id);
		if(product_ref==null)
		{
			return null;
		}
		else
		{
			return product_ref;
		}
	}
}
