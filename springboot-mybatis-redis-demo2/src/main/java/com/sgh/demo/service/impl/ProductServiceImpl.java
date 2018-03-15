/**
 * 
 */
package com.sgh.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgh.demo.dao.domain.Product;
import com.sgh.demo.dao.mapper.ProductMapper;
import com.sgh.demo.service.ProductService;

/**
 * @author eguoshi
 *
 */
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductMapper productMapper;

	@Override
	public Product findProductById(Long id) {
		return productMapper.select(id);
	}


	@Override
	public void updateProduct(Product product) {
		productMapper.update(product);
	}
}
