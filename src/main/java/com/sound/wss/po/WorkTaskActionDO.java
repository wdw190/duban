package com.sound.wss.po;

import java.io.Serializable;

public class WorkTaskActionDO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8955279796029917424L;

	private String id;
	private String workOrTaskId;
	private String author;
	private String actionType;
	private String actionBody;
	private String created;
	private String updateAuthor;
	private String updated;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getWorkOrTaskId() {
		return workOrTaskId;
	}

	public void setWorkOrTaskId(String workOrTaskId) {
		this.workOrTaskId = workOrTaskId;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public String getActionBody() {
		return actionBody;
	}

	public void setActionBody(String actionBody) {
		this.actionBody = actionBody;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getUpdateAuthor() {
		return updateAuthor;
	}

	public void setUpdateAuthor(String updateAuthor) {
		this.updateAuthor = updateAuthor;
	}

	public String getUpdated() {
		return updated;
	}

	public void setUpdated(String updated) {
		this.updated = updated;
	}

	@Override
	public String toString() {
		return "WorkTaskActionDO [id=" + id + ", workOrTaskId=" + workOrTaskId + ", author=" + author + ", actionType="
				+ actionType + ", actionBody=" + actionBody + ", created=" + created + ", updateAuthor=" + updateAuthor
				+ ", updated=" + updated + "]";
	}

}
