/**
 * 
 */
package com.sgh.demo.service;

import com.sgh.demo.domain.City;

/**
 * @author eguoshi
 *
 */
public interface CityService {
	City findCityByName(String cityName);
}
