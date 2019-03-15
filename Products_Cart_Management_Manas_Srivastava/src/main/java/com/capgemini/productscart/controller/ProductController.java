package com.capgemini.productscart.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.productscart.bean.Product;
import com.capgemini.productscart.service.IProductService;

@RestController
public class ProductController {

	/*(non-javadoc)
	*creating reference to IProductService
	*/
	@Autowired
	IProductService iProductService;
	
	/*
	 * when product is to be added
	 * then pass values in json body 
	 * and enter url given below with request method: POST  
	 * http://localhost:8090/addProduct
	 */
	@RequestMapping(method=RequestMethod.POST, value="/addProduct")
	public Product createProduct(@Valid @RequestBody Product product){
		return iProductService.createProduct(product);
	}
	
	/*
	 * when product is to be updated then 
	 * pass product to be updated values in json body 
	 * and enter url given below with request method: PUT  
	 * http://localhost:8090/products
	 */
	@RequestMapping(method=RequestMethod.PUT, value="/products")
	public Product updateProduct(@Valid @RequestBody Product product){
		return iProductService.updateProduct(product);
	}
	
	/*
	 * when product is to be deleted then 
	 * pass id in url  
	 * and enter url given below with request method: DELETE  
	 * http://localhost:8090/products/{id}
	 */
	@RequestMapping(method=RequestMethod.DELETE, value="/products/{id}")
	public String deleteProduct(@PathVariable String id){
		return iProductService.deleteProduct(id);
	}
	
	/*
	 * when all products are to be viewed 
	 * then enter url given below with request method: GET 
	 * http://localhost:8090/products
	 */
	@RequestMapping(method=RequestMethod.GET, value="/products")
	public List<Product> viewAllProduct(){
		return iProductService.viewAllProducts();
	}
	
	/*
	 * when product is to be deleted then 
	 * pass id in url  
	 * and enter url given below with request method: POST  
	 * http://localhost:8090/findProduct/{id}
	 */
	@RequestMapping(method=RequestMethod.POST, value="/findProduct/{id}")
	public Product findProduct(@PathVariable String id){
		return iProductService.findProduct(id);
	}

}
