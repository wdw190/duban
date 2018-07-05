package com.sound.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sound.battery.mybatis.model.BatteryConfigM;
import com.sound.battery.mybatis.model.BatteryConfigResultM;
import com.sound.battery.service.BatteryService;
import com.sound.model.CustomerRequirementM;

@RestController
@RequestMapping("/battery")
public class BatteryController {

	private BatteryService batteryService;

	@RequestMapping(value = "/combinationData", method = RequestMethod.POST, headers = "content-type=application/json")
	@ResponseBody
	public BatteryConfigResultM batteryData(@RequestBody CustomerRequirementM customerRequirementM) {

		BatteryConfigResultM batteryConfigResultM = new BatteryConfigResultM();
		List<BatteryConfigM> batteryConfigMLists = this.batteryService.queryData(customerRequirementM);

		if (batteryConfigMLists != null && batteryConfigMLists.size() > 0) {
			batteryConfigResultM.setBatteryConfigResult(batteryConfigMLists);
			batteryConfigResultM.setMsg("S");

		} else {
			batteryConfigResultM.setBatteryConfigResult(null);
			batteryConfigResultM.setMsg("F");
		}

		return batteryConfigResultM;

	}

	@RequestMapping(value = "/combinationData2", method = RequestMethod.GET)
	@ResponseBody
	public BatteryConfigResultM batteryData2() {
		CustomerRequirementM customerRequirementM = new CustomerRequirementM();
		customerRequirementM.setDymin(100);
		customerRequirementM.setDymax(600);
		customerRequirementM.setDlmin(100);
		customerRequirementM.setDlmax(200);
		customerRequirementM.setDcxslmin(1);
		customerRequirementM.setDcxslmax(20);
		BatteryConfigResultM batteryConfigResultM = new BatteryConfigResultM();
		List<BatteryConfigM> batteryConfigMLists = this.batteryService.queryData(customerRequirementM);

		if (batteryConfigMLists != null && batteryConfigMLists.size() > 0) {
			batteryConfigResultM.setBatteryConfigResult(batteryConfigMLists);
			batteryConfigResultM.setMsg("S");

		} else {
			batteryConfigResultM.setBatteryConfigResult(null);
			batteryConfigResultM.setMsg("F");
		}

		return batteryConfigResultM;

	}

	public BatteryService getBatteryService() {
		return batteryService;
	}

	@Autowired
	@Required
	public void setBatteryService(@Qualifier("defaultBatteryService") BatteryService batteryService) {
		this.batteryService = batteryService;
	}

}
