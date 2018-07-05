package com.sound.wss.bo;

import java.io.Serializable;
import java.util.List;

import com.sound.wss.po.TreeNodeDO;

public class TreeNodeBO extends TreeNodeDO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5800006918407819351L;
	
	private List<TreeNodeDO> nodes;

	public List<TreeNodeDO> getNodes() {
		return nodes;
	}

	public void setNodes(List<TreeNodeDO> nodes) {
		this.nodes = nodes;
	}

	@Override
	public String toString() {
		return "TreeNodeBO [nodes=" + nodes + ", toString()=" + super.toString() + "]";
	}
	
	
	

}
