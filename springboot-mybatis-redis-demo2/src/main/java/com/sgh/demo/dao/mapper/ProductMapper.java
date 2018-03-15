package com.sgh.demo.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sgh.demo.dao.domain.Product;

@Mapper
public interface ProductMapper {
	Product select(@Param("id") long id);

	void update(Product product);
}
