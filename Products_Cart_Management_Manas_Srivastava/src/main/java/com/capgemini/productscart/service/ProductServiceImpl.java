package com.capgemini.productscart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.productscart.bean.Product;
import com.capgemini.productscart.dao.IProductRepo;
import com.capgemini.productscart.exceptions.ProductAlreadyExistsException;
import com.capgemini.productscart.exceptions.ProductDoesnotExistException;

@Service
public class ProductServiceImpl implements IProductService {

	/*(non-javadoc)
	*creating reference to IProductRepo 
	*/
	@Autowired
	IProductRepo iProductRepo;
	
	/*(non-javadoc)
	*pass product to Repo layer
	*/
	@Override
	public Product createProduct(Product product) {
		if(iProductRepo.save(product)==null)
		{
			throw new ProductAlreadyExistsException("Exception : Product Already Exist In Records"); // if product already exists then throws an exception
		}
		else
		{
			return product;
		}
	}

	/*(non-javadoc)
	*update product details 
	*/
	@Override
	public Product updateProduct(Product product) {
		Product product_ref = iProductRepo.update(product);
		if(product_ref==null) 
		{
			throw new ProductDoesnotExistException("Exception : Product You Want To Update Doesnot Exist \n Try Creating New Product");// if product doesnot exist which is to be a updated then throws exception
		}
		else
		{
			return product_ref;
		}
		
	}

	/*(non-javadoc)
	*delete product from database
	**/
	@Override
	public String deleteProduct(String id) {
		if(iProductRepo.delete(id)) 
		{
			return "Product Removed Succesfully";
		}
		else
		{
			throw new ProductDoesnotExistException("Exception : Product Doesnot Exist");// if product is not present which is to be deleted then throws exception
		}
		
	}

	/*(non-javadoc)
	*to view all products
	*/
	@Override
	public List<Product> viewAllProducts() {
		List<Product> list = iProductRepo.findAll();
		if(list.size()==0)
		{
			throw new ProductDoesnotExistException("No Product Is Existing");// if no product is existing then throws exception
		}
		else
		{
			return list;
		}
	}

	/*(non-javadoc)
	*to view single product 
	*/
	@Override
	public Product findProduct(String id) {
		Product product = iProductRepo.find(id);
		if(product==null) {
			throw new ProductDoesnotExistException("Exception : Product  Doesnot Exist");//if product is not present then throws exception
		}
		else
		{
			return product;
		}
	}	
}