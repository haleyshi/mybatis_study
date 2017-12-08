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
	City findCityById(Long id);
	Long saveCity(City city);
	Long updateCity(City city);
	Long deleteCity(Long id);
}
