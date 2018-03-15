package com.sgh.demo.common;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 6578145566165417422L;

	public ProductNotFoundException(long productId) {
        super("Couldn't find product '" + productId + "'.");
    }
}