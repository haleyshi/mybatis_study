/**
 * 
 */
package com.sgh.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgh.demo.dao.ds2.UserDao;
import com.sgh.demo.domain.User;
import com.sgh.demo.service.UserService;

/**
 * @author eguoshi
 *
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
    private UserDao userDao; // 主数据源

	/* (non-Javadoc)
	 * @see com.sgh.demo.service.UserService#findById(long)
	 */
	@Override
	public User findUserById(Long id) {
		return userDao.findById(id);
	}

}
