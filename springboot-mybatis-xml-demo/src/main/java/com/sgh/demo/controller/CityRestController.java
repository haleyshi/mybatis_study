/**
 * 
 */
package com.sgh.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sgh.demo.domain.City;
import com.sgh.demo.service.CityService;

/**
 * @author eguoshi
 *
 */
@RestController
public class CityRestController {
	@Autowired
	private CityService cityService;

	@RequestMapping(value = "/api/city", method = RequestMethod.GET)
	public City findOneCity(@RequestParam(value = "cityName", required = true) String cityName) {
		return cityService.findCityByName(cityName);
	}
}
