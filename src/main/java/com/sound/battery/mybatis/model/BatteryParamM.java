package com.sound.battery.mybatis.model;

import java.io.Serializable;

public class BatteryParamM implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4307494938874201772L;

	private String id;//
	private String xxh;// 箱型号
	private String cpbh;// 产品编号
	private String dm;// 代码
	private String cbs1;// 串并数1
	private String cbs2;// 串并数2
	private int cbs3;// 串并数3
	private String cbs4;// 串并数4
	private float dtdxbcdl;// 单体电芯标称电量
	private float dtdxsjdl;// 单体电芯实际电量
	private float dtdxgzdy;// 单体电芯工作电压
	private float dxdl;// 典型电量
	private float sjdl;// 实际电量
	private float zlinptc;// 质量KG(±5%)含PTC
	private float zlexptc;// 质量KG(±5%)不含PTC
	private float dxnlmdinptc;// 典型能量密度wh/kg含PTC
	private float dxnlmdexptc;// 典型能量密度wh/kg不含PTC
	private float sjnlmdinptc;// 实际能量密度wh/kg含PTC
	private float sjnlmdexptc;// 实际能量密度wh/kg不含PTC
	private float xtrl;// 箱体容量AH
	private float xtdy;// 箱体电压V
	private float bzxczxl;// 标准箱成组效率含PTC
	private float bzxczxlexptc; // 标准箱成组效率不含PTC

	private String cltx;//材料体系
	private String zdcc;//最大尺寸
	private String fsfcdj;//防水防尘等级

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getXxh() {
		return xxh;
	}

	public void setXxh(String xxh) {
		this.xxh = xxh;
	}

	public String getCpbh() {
		return cpbh;
	}

	public void setCpbh(String cpbh) {
		this.cpbh = cpbh;
	}

	public String getDm() {
		return dm;
	}

	public void setDm(String dm) {
		this.dm = dm;
	}

	public String getCbs1() {
		return cbs1;
	}

	public void setCbs1(String cbs1) {
		this.cbs1 = cbs1;
	}

	public String getCbs2() {
		return cbs2;
	}

	public void setCbs2(String cbs2) {
		this.cbs2 = cbs2;
	}

	public int getCbs3() {
		return cbs3;
	}

	public void setCbs3(int cbs3) {
		this.cbs3 = cbs3;
	}

	public String getCbs4() {
		return cbs4;
	}

	public void setCbs4(String cbs4) {
		this.cbs4 = cbs4;
	}

	public float getDtdxbcdl() {
		return dtdxbcdl;
	}

	public void setDtdxbcdl(float dtdxbcdl) {
		this.dtdxbcdl = dtdxbcdl;
	}

	public float getDtdxsjdl() {
		return dtdxsjdl;
	}

	public void setDtdxsjdl(float dtdxsjdl) {
		this.dtdxsjdl = dtdxsjdl;
	}

	public float getDtdxgzdy() {
		return dtdxgzdy;
	}

	public void setDtdxgzdy(float dtdxgzdy) {
		this.dtdxgzdy = dtdxgzdy;
	}

	public float getDxdl() {
		return dxdl;
	}

	public void setDxdl(float dxdl) {
		this.dxdl = dxdl;
	}

	public float getSjdl() {
		return sjdl;
	}

	public void setSjdl(float sjdl) {
		this.sjdl = sjdl;
	}

	public float getZlinptc() {
		return zlinptc;
	}

	public void setZlinptc(float zlinptc) {
		this.zlinptc = zlinptc;
	}

	public float getZlexptc() {
		return zlexptc;
	}

	public void setZlexptc(float zlexptc) {
		this.zlexptc = zlexptc;
	}

	public float getDxnlmdinptc() {
		return dxnlmdinptc;
	}

	public void setDxnlmdinptc(float dxnlmdinptc) {
		this.dxnlmdinptc = dxnlmdinptc;
	}

	public float getDxnlmdexptc() {
		return dxnlmdexptc;
	}

	public void setDxnlmdexptc(float dxnlmdexptc) {
		this.dxnlmdexptc = dxnlmdexptc;
	}

	public float getSjnlmdinptc() {
		return sjnlmdinptc;
	}

	public void setSjnlmdinptc(float sjnlmdinptc) {
		this.sjnlmdinptc = sjnlmdinptc;
	}

	public float getSjnlmdexptc() {
		return sjnlmdexptc;
	}

	public void setSjnlmdexptc(float sjnlmdexptc) {
		this.sjnlmdexptc = sjnlmdexptc;
	}

	public float getXtrl() {
		return xtrl;
	}

	public void setXtrl(float xtrl) {
		this.xtrl = xtrl;
	}

	public float getXtdy() {
		return xtdy;
	}

	public void setXtdy(float xtdy) {
		this.xtdy = xtdy;
	}

	public float getBzxczxl() {
		return bzxczxl;
	}

	public void setBzxczxl(float bzxczxl) {
		this.bzxczxl = bzxczxl;
	}

	public float getBzxczxlexptc() {
		return bzxczxlexptc;
	}

	public void setBzxczxlexptc(float bzxczxlexptc) {
		this.bzxczxlexptc = bzxczxlexptc;
	}

	public String getCltx() {
		return cltx;
	}

	public void setCltx(String cltx) {
		this.cltx = cltx;
	}

	public String getZdcc() {
		return zdcc;
	}

	public void setZdcc(String zdcc) {
		this.zdcc = zdcc;
	}

	public String getFsfcdj() {
		return fsfcdj;
	}

	public void setFsfcdj(String fsfcdj) {
		this.fsfcdj = fsfcdj;
	}

	@Override
	public String toString() {
		return "BatteryParamM [id=" + id + ", xxh=" + xxh + ", cpbh=" + cpbh + ", dm=" + dm + ", cbs1=" + cbs1
				+ ", cbs2=" + cbs2 + ", cbs3=" + cbs3 + ", cbs4=" + cbs4 + ", dtdxbcdl=" + dtdxbcdl + ", dtdxsjdl="
				+ dtdxsjdl + ", dtdxgzdy=" + dtdxgzdy + ", dxdl=" + dxdl + ", sjdl=" + sjdl + ", zlinptc=" + zlinptc
				+ ", zlexptc=" + zlexptc + ", dxnlmdinptc=" + dxnlmdinptc + ", dxnlmdexptc=" + dxnlmdexptc
				+ ", sjnlmdinptc=" + sjnlmdinptc + ", sjnlmdexptc=" + sjnlmdexptc + ", xtrl=" + xtrl + ", xtdy=" + xtdy
				+ ", bzxczxl=" + bzxczxl + ", bzxczxlexptc=" + bzxczxlexptc + ", cltx=" + cltx + ", zdcc=" + zdcc
				+ ", fsfcdj=" + fsfcdj + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(bzxczxl);
		result = prime * result + Float.floatToIntBits(bzxczxlexptc);
		result = prime * result + ((cbs1 == null) ? 0 : cbs1.hashCode());
		result = prime * result + ((cbs2 == null) ? 0 : cbs2.hashCode());
		result = prime * result + cbs3;
		result = prime * result + ((cbs4 == null) ? 0 : cbs4.hashCode());
		result = prime * result + ((cltx == null) ? 0 : cltx.hashCode());
		result = prime * result + ((cpbh == null) ? 0 : cpbh.hashCode());
		result = prime * result + ((dm == null) ? 0 : dm.hashCode());
		result = prime * result + Float.floatToIntBits(dtdxbcdl);
		result = prime * result + Float.floatToIntBits(dtdxgzdy);
		result = prime * result + Float.floatToIntBits(dtdxsjdl);
		result = prime * result + Float.floatToIntBits(dxdl);
		result = prime * result + Float.floatToIntBits(dxnlmdexptc);
		result = prime * result + Float.floatToIntBits(dxnlmdinptc);
		result = prime * result + ((fsfcdj == null) ? 0 : fsfcdj.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + Float.floatToIntBits(sjdl);
		result = prime * result + Float.floatToIntBits(sjnlmdexptc);
		result = prime * result + Float.floatToIntBits(sjnlmdinptc);
		result = prime * result + Float.floatToIntBits(xtdy);
		result = prime * result + Float.floatToIntBits(xtrl);
		result = prime * result + ((xxh == null) ? 0 : xxh.hashCode());
		result = prime * result + ((zdcc == null) ? 0 : zdcc.hashCode());
		result = prime * result + Float.floatToIntBits(zlexptc);
		result = prime * result + Float.floatToIntBits(zlinptc);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BatteryParamM other = (BatteryParamM) obj;
		if (Float.floatToIntBits(bzxczxl) != Float.floatToIntBits(other.bzxczxl))
			return false;
		if (Float.floatToIntBits(bzxczxlexptc) != Float.floatToIntBits(other.bzxczxlexptc))
			return false;
		if (cbs1 == null) {
			if (other.cbs1 != null)
				return false;
		} else if (!cbs1.equals(other.cbs1))
			return false;
		if (cbs2 == null) {
			if (other.cbs2 != null)
				return false;
		} else if (!cbs2.equals(other.cbs2))
			return false;
		if (cbs3 != other.cbs3)
			return false;
		if (cbs4 == null) {
			if (other.cbs4 != null)
				return false;
		} else if (!cbs4.equals(other.cbs4))
			return false;
		if (cltx == null) {
			if (other.cltx != null)
				return false;
		} else if (!cltx.equals(other.cltx))
			return false;
		if (cpbh == null) {
			if (other.cpbh != null)
				return false;
		} else if (!cpbh.equals(other.cpbh))
			return false;
		if (dm == null) {
			if (other.dm != null)
				return false;
		} else if (!dm.equals(other.dm))
			return false;
		if (Float.floatToIntBits(dtdxbcdl) != Float.floatToIntBits(other.dtdxbcdl))
			return false;
		if (Float.floatToIntBits(dtdxgzdy) != Float.floatToIntBits(other.dtdxgzdy))
			return false;
		if (Float.floatToIntBits(dtdxsjdl) != Float.floatToIntBits(other.dtdxsjdl))
			return false;
		if (Float.floatToIntBits(dxdl) != Float.floatToIntBits(other.dxdl))
			return false;
		if (Float.floatToIntBits(dxnlmdexptc) != Float.floatToIntBits(other.dxnlmdexptc))
			return false;
		if (Float.floatToIntBits(dxnlmdinptc) != Float.floatToIntBits(other.dxnlmdinptc))
			return false;
		if (fsfcdj == null) {
			if (other.fsfcdj != null)
				return false;
		} else if (!fsfcdj.equals(other.fsfcdj))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (Float.floatToIntBits(sjdl) != Float.floatToIntBits(other.sjdl))
			return false;
		if (Float.floatToIntBits(sjnlmdexptc) != Float.floatToIntBits(other.sjnlmdexptc))
			return false;
		if (Float.floatToIntBits(sjnlmdinptc) != Float.floatToIntBits(other.sjnlmdinptc))
			return false;
		if (Float.floatToIntBits(xtdy) != Float.floatToIntBits(other.xtdy))
			return false;
		if (Float.floatToIntBits(xtrl) != Float.floatToIntBits(other.xtrl))
			return false;
		if (xxh == null) {
			if (other.xxh != null)
				return false;
		} else if (!xxh.equals(other.xxh))
			return false;
		if (zdcc == null) {
			if (other.zdcc != null)
				return false;
		} else if (!zdcc.equals(other.zdcc))
			return false;
		if (Float.floatToIntBits(zlexptc) != Float.floatToIntBits(other.zlexptc))
			return false;
		if (Float.floatToIntBits(zlinptc) != Float.floatToIntBits(other.zlinptc))
			return false;
		return true;
	}
	
	


	

}
