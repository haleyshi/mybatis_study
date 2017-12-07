/**
 * 
 */
package com.sgh.demo.dao.ds1;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sgh.demo.domain.City;

/**
 * @author eguoshi
 *
 */
@Mapper
public interface CityDao {

	/**
	 * 根据城市名称，查询城市信息
	 *
	 * @param cityName
	 *            城市名
	 */
	City findByName(@Param("cityName") String cityName);
}
