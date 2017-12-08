/**
 * 
 */
package com.sgh.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sgh.demo.domain.City;

/**
 * @author eguoshi
 *
 */
public interface CityDao {

	City findById(@Param("id") Long id);
	
	List<City> findAllCity();
	
	Long saveCity(City city);

    Long updateCity(City city);

    Long deleteCity(Long id);
}
