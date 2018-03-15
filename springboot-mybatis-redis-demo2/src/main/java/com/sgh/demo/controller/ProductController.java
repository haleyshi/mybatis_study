/**
 * 
 */
package com.sgh.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgh.demo.common.ProductNotFoundException;
import com.sgh.demo.dao.domain.Product;
import com.sgh.demo.service.ProductService;

/**
 * @author eguoshi
 *
 */
@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;

	@GetMapping("/{id}")
	public Product getProductInfo(@PathVariable("id") Long id) {
		return productService.findProductById(id);
	}

	@PutMapping("/{id}")
	public Product updateProductInfo(@PathVariable("id") Long id, @RequestBody Product newProduct) {
		Product product = productService.findProductById(id);
		if (product == null) {
			throw new ProductNotFoundException(id);
		}
		
		product.setName(newProduct.getName());
		product.setPrice(newProduct.getPrice());
		productService.updateProduct(product);
		
		return product;
	}
}
