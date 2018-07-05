package com.sound.wss.properties;

import java.io.Serializable;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
@Component("wssProperties")
@ConfigurationProperties(prefix = "sound.config")
public class WSSProperties implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6407024778696955294L;
	
	private Integer depId;

	public Integer getDepId() {
		return depId;
	}

	public void setDepId(Integer depId) {
		this.depId = depId;
	}
	
	
	

}
