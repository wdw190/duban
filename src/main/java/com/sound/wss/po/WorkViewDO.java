package com.sound.wss.po;

import java.io.Serializable;

public class WorkViewDO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7442997623839595870L;

	private int all;

	private int open;

	private int done;

	private int delay;

	private int cancel;

	public int getAll() {
		return all;
	}

	public void setAll(int all) {
		this.all = all;
	}

	public int getOpen() {
		return open;
	}

	public void setOpen(int open) {
		this.open = open;
	}

	public int getDone() {
		return done;
	}

	public void setDone(int done) {
		this.done = done;
	}

	public int getDelay() {
		return delay;
	}

	public void setDelay(int delay) {
		this.delay = delay;
	}

	public int getCancel() {
		return cancel;
	}

	public void setCancel(int cancel) {
		this.cancel = cancel;
	}

	@Override
	public String toString() {
		return "WorkViewDO [all=" + all + ", open=" + open + ", done=" + done + ", delay=" + delay + ", cancel="
				+ cancel + "]";
	}

}
