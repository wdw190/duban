package com.sound.battery.mybatis.model;

public class BatteryConfigM {

	private String id;
	private int axcs;// A箱串数
	private int bxcs;// B箱串数
	private float bcdl;// 标称电量/KWH
	private float dypt;// 电压平台/V
	private float bcrl; // 标称容量/Ah
	private int dxzhfs1; // 电箱组合方式1--A箱数量
	private String dxzhfs2; // 电箱组合方式2--A箱代码
	private int dxzhfs3; // 电箱组合方式3--B箱数量
	private String dxzhfs4; // 电箱组合方式4--B箱代码
	private int xtzc; // 系统总串
	private int xtzb; // 系统总并
	private int xtxs; // 系统箱数
	private String sycxcode; // 适用车型代码
	private String sycxdesc; // 适用车型描述
	private float dxnlmd; // 典型能量密度wh/kg
	private float axzl; // A箱质量(不含PTC)Kg
	private float bxzl; // B箱质量(不含PTC)Kg
	private float dxbcrl; // 电芯标称容量

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAxcs() {
		return axcs;
	}

	public void setAxcs(int axcs) {
		this.axcs = axcs;
	}

	public int getBxcs() {
		return bxcs;
	}

	public void setBxcs(int bxcs) {
		this.bxcs = bxcs;
	}

	public float getBcdl() {
		return bcdl;
	}

	public void setBcdl(float bcdl) {
		this.bcdl = bcdl;
	}

	public float getDypt() {
		return dypt;
	}

	public void setDypt(float dypt) {
		this.dypt = dypt;
	}

	public float getBcrl() {
		return bcrl;
	}

	public void setBcrl(float bcrl) {
		this.bcrl = bcrl;
	}

	public int getDxzhfs1() {
		return dxzhfs1;
	}

	public void setDxzhfs1(int dxzhfs1) {
		this.dxzhfs1 = dxzhfs1;
	}

	public String getDxzhfs2() {
		return dxzhfs2;
	}

	public void setDxzhfs2(String dxzhfs2) {
		this.dxzhfs2 = dxzhfs2;
	}

	public int getDxzhfs3() {
		return dxzhfs3;
	}

	public void setDxzhfs3(int dxzhfs3) {
		this.dxzhfs3 = dxzhfs3;
	}

	public String getDxzhfs4() {
		return dxzhfs4;
	}

	public void setDxzhfs4(String dxzhfs4) {
		this.dxzhfs4 = dxzhfs4;
	}

	public int getXtzc() {
		return xtzc;
	}

	public void setXtzc(int xtzc) {
		this.xtzc = xtzc;
	}

	public int getXtzb() {
		return xtzb;
	}

	public void setXtzb(int xtzb) {
		this.xtzb = xtzb;
	}

	public int getXtxs() {
		return xtxs;
	}

	public void setXtxs(int xtxs) {
		this.xtxs = xtxs;
	}

	public String getSycxcode() {
		return sycxcode;
	}

	public void setSycxcode(String sycxcode) {
		this.sycxcode = sycxcode;
	}

	public String getSycxdesc() {
		return sycxdesc;
	}

	public void setSycxdesc(String sycxdesc) {
		this.sycxdesc = sycxdesc;
	}

	public float getDxnlmd() {
		return dxnlmd;
	}

	public void setDxnlmd(float dxnlmd) {
		this.dxnlmd = dxnlmd;
	}

	public float getAxzl() {
		return axzl;
	}

	public void setAxzl(float axzl) {
		this.axzl = axzl;
	}

	public float getBxzl() {
		return bxzl;
	}

	public void setBxzl(float bxzl) {
		this.bxzl = bxzl;
	}

	public float getDxbcrl() {
		return dxbcrl;
	}

	public void setDxbcrl(float dxbcrl) {
		this.dxbcrl = dxbcrl;
	}

	@Override
	public String toString() {
		return "BatteryConfigM [id=" + id + ", axcs=" + axcs + ", bxcs=" + bxcs + ", bcdl=" + bcdl + ", dypt=" + dypt
				+ ", bcrl=" + bcrl + ", dxzhfs1=" + dxzhfs1 + ", dxzhfs2=" + dxzhfs2 + ", dxzhfs3=" + dxzhfs3
				+ ", dxzhfs4=" + dxzhfs4 + ", xtzc=" + xtzc + ", xtzb=" + xtzb + ", xtxs=" + xtxs + ", sycxcode="
				+ sycxcode + ", sycxdesc=" + sycxdesc + ", dxnlmd=" + dxnlmd + ", axzl=" + axzl + ", bxzl=" + bxzl
				+ ", dxbcrl=" + dxbcrl + "]";
	}



}
