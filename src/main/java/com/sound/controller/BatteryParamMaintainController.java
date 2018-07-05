package com.sound.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sound.battery.mybatis.model.BatteryParamM;
import com.sound.battery.service.BatteryParamService;
import com.sound.model.ResponseMessageM;

@Controller
@RequestMapping("/battery/maintain")
public class BatteryParamMaintainController {

	private BatteryParamService batteryParamService;

	@RequestMapping(path = "/index")
	public ModelAndView maintainIndex() {

		ModelAndView mav = new ModelAndView("battery/index");

		mav.addObject("xxh", this.batteryParamService.queryDistinctXXH());

		mav.addObject("cpbh", this.batteryParamService.queryDistinctCPBH());

		mav.addObject("dm", this.batteryParamService.queryDistinctDM());
		return mav;
	}

	@RequestMapping(path = "/view/{id}")
	public ModelAndView maintainView(@PathVariable(name = "id") String id) {

		BatteryParamM atteryParamM = this.batteryParamService.queryBatteryParamById(id);

		ModelAndView mav = new ModelAndView("battery/view");
		mav.addObject("batteryparamviewresult", atteryParamM);
		return mav;

	}

	/**
	 * 跳转到新增页面
	 * 
	 * @return
	 */
	@RequestMapping(path = "/create")
	public String maintainCreate() {

		return "battery/create";
	}

	public BatteryParamService getBatteryParamService() {
		return batteryParamService;
	}

	@Autowired
	@Required
	public void setBatteryParamService(
			@Qualifier("defaultBatteryParamService") BatteryParamService batteryParamService) {
		this.batteryParamService = batteryParamService;
	}

}
