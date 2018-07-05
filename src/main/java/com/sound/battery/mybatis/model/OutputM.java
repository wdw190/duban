package com.sound.battery.mybatis.model;

import java.io.Serializable;

public class OutputM implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7634749007010103939L;

	private float ptdy;// 平台电压
	private float fdjzdy;// 放电截止电压
	private float cdjzdy;// 充电截止电压
	private float xtbcrl;// 系统标称容量
	private float xtdl;// 系统电量
	private int anum;// A箱个数
	private int bnum;// B箱个数
	private float zl;// 重量
	private float xtnlmd;// 系统能量密度
	private float btxs;// 补贴系数
	private float btje;// 补贴金额

	private String adm;
	private String bdm;

	public float getPtdy() {
		return ptdy;
	}

	public void setPtdy(float ptdy) {
		this.ptdy = ptdy;
	}

	public float getFdjzdy() {
		return fdjzdy;
	}

	public void setFdjzdy(float fdjzdy) {
		this.fdjzdy = fdjzdy;
	}

	public float getCdjzdy() {
		return cdjzdy;
	}

	public void setCdjzdy(float cdjzdy) {
		this.cdjzdy = cdjzdy;
	}

	public float getXtbcrl() {
		return xtbcrl;
	}

	public void setXtbcrl(float xtbcrl) {
		this.xtbcrl = xtbcrl;
	}

	public float getXtdl() {
		return xtdl;
	}

	public void setXtdl(float xtdl) {
		this.xtdl = xtdl;
	}

	public int getAnum() {
		return anum;
	}

	public void setAnum(int anum) {
		this.anum = anum;
	}

	public int getBnum() {
		return bnum;
	}

	public void setBnum(int bnum) {
		this.bnum = bnum;
	}

	public float getZl() {
		return zl;
	}

	public void setZl(float zl) {
		this.zl = zl;
	}

	public float getXtnlmd() {
		return xtnlmd;
	}

	public void setXtnlmd(float xtnlmd) {
		this.xtnlmd = xtnlmd;
	}

	public float getBtxs() {
		return btxs;
	}

	public void setBtxs(float btxs) {
		this.btxs = btxs;
	}

	public float getBtje() {
		return btje;
	}

	public void setBtje(float btje) {
		this.btje = btje;
	}

	public String getAdm() {
		return adm;
	}

	public void setAdm(String adm) {
		this.adm = adm;
	}

	public String getBdm() {
		return bdm;
	}

	public void setBdm(String bdm) {
		this.bdm = bdm;
	}

	@Override
	public String toString() {
		return "OutputM [ptdy=" + ptdy + ", fdjzdy=" + fdjzdy + ", cdjzdy=" + cdjzdy + ", xtbcrl=" + xtbcrl + ", xtdl="
				+ xtdl + ", anum=" + anum + ", bnum=" + bnum + ", zl=" + zl + ", xtnlmd=" + xtnlmd + ", btxs=" + btxs
				+ ", btje=" + btje + ", adm=" + adm + ", bdm=" + bdm + "]";
	}

}
