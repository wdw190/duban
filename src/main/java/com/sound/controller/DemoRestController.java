package com.sound.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sound.sample.mybatis.domain.City;
import com.sound.sample.mybatis.service.CityService;

@RestController
public class DemoRestController {

	private CityService cityService;

	@RequestMapping(path = "/city/{id}")
	public City selectCityById(@PathVariable(name = "id") long id) {

		return this.cityService.selectCityById(id);
	}

	public CityService getCityService() {
		return cityService;
	}

	@Autowired
	@Required
	public void setCityService(@Qualifier(value = "cityService") CityService cityService) {
		this.cityService = cityService;
	}

}
