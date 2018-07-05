package com.sound.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sound.battery.mybatis.model.OutputM;
import com.sound.battery.service.BatteryOutputService;
import com.sound.battery.service.BatteryParamService;

@Controller
public class BatteryViewController {

	private BatteryOutputService batteryOutputService;

	private BatteryParamService batteryParamService;

	@RequestMapping(path = "/report/view/{id}")
	public ModelAndView viewPage(@PathVariable(name = "id") String id) {

		ModelAndView mav = new ModelAndView("report/view");

		OutputM outputM = this.batteryOutputService.queryById(id);

		mav.addObject("outputresult", outputM);
		mav.addObject("abox", this.batteryParamService.queryBatteryParamByDm(outputM.getAdm()));
		mav.addObject("bbox", this.batteryParamService.queryBatteryParamByDm(outputM.getBdm()));
		return mav;

	}

	public BatteryOutputService getBatteryOutputService() {
		return batteryOutputService;
	}

	@Autowired
	@Required
	public void setBatteryOutputService(
			@Qualifier("defaultBatteryOutputService") BatteryOutputService batteryOutputService) {
		this.batteryOutputService = batteryOutputService;
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
