package com.capgemini.productscart.exceptions;

public class ProductAlreadyExistsException extends RuntimeException {

	public ProductAlreadyExistsException(String string) {
		super(string);
	}

}
