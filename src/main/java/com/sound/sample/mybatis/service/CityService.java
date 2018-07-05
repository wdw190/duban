package com.sound.sample.mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

import com.sound.sample.mybatis.dao.CityDao;
import com.sound.sample.mybatis.domain.City;

@Service(value = "cityService")
public class CityService {

	private CityDao cityDao;

	public City selectCityById(long id) {
		return this.cityDao.selectCityById(id);
	}

	public CityDao getCityDao() {
		return cityDao;
	}

	@Autowired
	@Required
	public void setCityDao(@Qualifier(value = "cityDao") CityDao cityDao) {
		this.cityDao = cityDao;
	}

}
