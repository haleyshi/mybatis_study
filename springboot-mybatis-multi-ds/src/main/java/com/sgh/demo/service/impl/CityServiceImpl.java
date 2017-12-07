/**
 * 
 */
package com.sgh.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgh.demo.dao.ds1.CityDao;
import com.sgh.demo.domain.City;
import com.sgh.demo.service.CityService;

/**
 * @author eguoshi
 *
 */
@Service
public class CityServiceImpl implements CityService {
	@Autowired
	private CityDao cityDao;

	public City findCityByName(String cityName) {
		return cityDao.findByName(cityName);
	}
}
