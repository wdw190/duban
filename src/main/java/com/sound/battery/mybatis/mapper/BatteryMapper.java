package com.sound.battery.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sound.battery.mybatis.model.BatteryConfigM;
import com.sound.model.CustomerRequirementM;

@Mapper
public interface BatteryMapper {

	public List<BatteryConfigM> queryByConditionModel(CustomerRequirementM customerRequirementM);

	public BatteryConfigM queryById(String id);

}
