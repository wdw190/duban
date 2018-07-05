package com.sound.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sound.battery.mybatis.model.BatteryParamM;
import com.sound.battery.mybatis.model.BatteryParamResultM;
import com.sound.battery.service.BatteryConfigService;
import com.sound.battery.service.BatteryParamService;
import com.sound.model.BatteryParamRequirementM;
import com.sound.model.ResponseMessageM;

@RestController

public class BatteryParamController {

	private BatteryParamService batteryParamService;

	private BatteryConfigService batteryConfigService;

	@RequestMapping(value = "/batteryparam/querydata", method = RequestMethod.POST, headers = "content-type=application/json")
	@ResponseBody
	public BatteryParamResultM queryData(@RequestBody BatteryParamRequirementM batteryParamRequirementM) {

		return this.batteryParamService.queryData(batteryParamRequirementM);

	}

	@RequestMapping(value = "/batteryparam/save", method = RequestMethod.POST, headers = "content-type=application/json")
	@ResponseBody
	public ResponseMessageM saveBatteryParamData(@RequestBody BatteryParamM batteryParamM) {
		ResponseMessageM responseMessageM = new ResponseMessageM();

		batteryParamM.setId(UUID.randomUUID().toString());
		// System.out.println(batteryParamM.toString());

		int noofRowsInserted = this.batteryParamService.insertBatteryParamM(batteryParamM);
		if (noofRowsInserted > 0) {

			responseMessageM.setFlag("S");
			responseMessageM.setMsg("成功插入电池箱参数");

		} else {
			responseMessageM.setFlag("F");
			responseMessageM.setMsg("新增电池箱参数失败，请重试!!");
		}

		return responseMessageM;

	}

	/**
	 * 
	 * @Title: @Description: 修改电池箱参数 @param @return ResponseMessageM
	 *         返回类型 @throws
	 *
	 */
	@RequestMapping(value = "/batteryparam/update", method = RequestMethod.POST, headers = "content-type=application/json")
	@ResponseBody
	public ResponseMessageM updateBatteryParamData(@RequestBody BatteryParamM batteryParamM) {
		ResponseMessageM responseMessageM = new ResponseMessageM();

		int onOfRowsUpdated = this.batteryParamService.updateBatteryParamM(batteryParamM);
		boolean updateFlag = this.batteryConfigService.BatchUpdateBatteryConfigInfos(batteryParamM);

		if (onOfRowsUpdated > 0 && updateFlag == true) {
			responseMessageM.setFlag("S");
			responseMessageM.setMsg("电池箱参数修改成功");
		} else {
			responseMessageM.setFlag("F");
			responseMessageM.setMsg("电池箱参数修改失败");
		}

		return responseMessageM;
	}

	/**
	 * 删除 @Title: @Description: (这里用一句话描述这个方法的作用) @param @return
	 * ResponseMessageM 返回类型 @throws
	 *
	 */
	@RequestMapping(value = "/batteryparam/delete/{id}")
	public ResponseMessageM deleteBatteryParamData(@PathVariable(name = "id") String id) {
		ResponseMessageM responseMessageM = new ResponseMessageM();
		int onOfRowsDeleted = this.batteryParamService.deleteBatteryParamM(id);
		if (onOfRowsDeleted > 0) {
			responseMessageM.setMsg("电池箱参数删除成功");
			responseMessageM.setFlag("S");
		} else {
			responseMessageM.setMsg("电池箱参数删除失败");
			responseMessageM.setFlag("F");

		}
		return responseMessageM;
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

	public BatteryConfigService getBatteryConfigService() {
		return batteryConfigService;
	}

	@Autowired
	@Required
	public void setBatteryConfigService(
			@Qualifier("defaultBatteryConfigService") BatteryConfigService batteryConfigService) {
		this.batteryConfigService = batteryConfigService;
	}

}
