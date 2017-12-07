/**
 * 
 */
package com.sgh.demo.service;

import com.sgh.demo.domain.User;

/**
 * @author eguoshi
 *
 */
public interface UserService {
	User findUserById(Long id);
}
