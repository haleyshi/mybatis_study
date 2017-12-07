/**
 * 
 */
package com.sgh.demo.dao.ds2;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sgh.demo.domain.User;

/**
 * @author eguoshi
 *
 */
@Mapper
public interface UserDao {
	User findById(@Param("id") Long id);
}
