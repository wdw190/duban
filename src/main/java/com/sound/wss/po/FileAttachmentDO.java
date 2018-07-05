package com.sound.wss.po;

import java.io.Serializable;

public class FileAttachmentDO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7689006818422603711L;

	private String id;
	private String workOrTaskId;
	private String mimetype;
	private String filename;
	private String created;
	private long filesize;
	private String author;
	private String path;
	private String downloadPath;

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

	public String getMimetype() {
		return mimetype;
	}

	public void setMimetype(String mimetype) {
		this.mimetype = mimetype;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public long getFilesize() {
		return filesize;
	}

	public void setFilesize(long filesize) {
		this.filesize = filesize;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getDownloadPath() {
		return downloadPath;
	}

	public void setDownloadPath(String downloadPath) {
		this.downloadPath = downloadPath;
	}

	@Override
	public String toString() {
		return "FileAttachmentDO [id=" + id + ", workOrTaskId=" + workOrTaskId + ", mimetype=" + mimetype
				+ ", filename=" + filename + ", created=" + created + ", filesize=" + filesize + ", author=" + author
				+ ", path=" + path + ", downloadPath=" + downloadPath + "]";
	}

}
