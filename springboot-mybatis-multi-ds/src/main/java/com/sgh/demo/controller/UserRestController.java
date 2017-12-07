/**
 * 
 */
package com.sgh.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sgh.demo.domain.User;
import com.sgh.demo.service.UserService;

/**
 * @author eguoshi
 *
 */
@RestController
public class UserRestController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/api/user", method = RequestMethod.GET)
	public User findOneUser(@RequestParam(value = "id", required = true) Long id) {
		return userService.findUserById(id);
	}
}
