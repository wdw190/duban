package com.sound.wss.po.wechat;

public class TextInfo {

	private String touser;
	private String toparty;
	private String totag;
	private String msgtype;

	private int agentid;
	private Text text;
	private int safe;

	public String getTouser() {
		return touser;
	}

	public void setTouser(String touser) {
		this.touser = touser;
	}

	public String getToparty() {
		return toparty;
	}

	public void setToparty(String toparty) {
		this.toparty = toparty;
	}

	public String getTotag() {
		return totag;
	}

	public void setTotag(String totag) {
		this.totag = totag;
	}

	public String getMsgtype() {
		return msgtype;
	}

	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}

	public int getAgentid() {
		return agentid;
	}

	public void setAgentid(int agentid) {
		this.agentid = agentid;
	}

	public Text getText() {
		return text;
	}

	public void setText(Text text) {
		this.text = text;
	}

	public int getSafe() {
		return safe;
	}

	public void setSafe(int safe) {
		this.safe = safe;
	}

	@Override
	public String toString() {
		return "TextInfo [touser=" + touser + ", toparty=" + toparty + ", totag=" + totag + ", msgtype=" + msgtype
				+ ", agentid=" + agentid + ", text=" + text + ", safe=" + safe + "]";
	}

	// {
	// "touser" : "UserID1|UserID2|UserID3",
	// "toparty" : " PartyID1|PartyID2 ",
	// "totag" : " TagID1 | TagID2 ",
	// "msgtype" : "text",
	// "agentid" : 1,
	// "text" : {
	// "content" : "你的快递已到，请携带工卡前往邮件中心领取。\n出发前可查看<a
	// href=\"http://work.weixin.qq.com\">邮件中心视频实况</a>，聪明避开排队。"
	// },
	// "safe":0
	// }

}
