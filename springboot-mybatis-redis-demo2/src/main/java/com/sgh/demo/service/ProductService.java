/**
 * 
 */
package com.sgh.demo.service;

import com.sgh.demo.dao.domain.Product;

/**
 * @author eguoshi
 *
 */
public interface ProductService {
	Product findProductById(Long id);
	void updateProduct(Product product);
}
