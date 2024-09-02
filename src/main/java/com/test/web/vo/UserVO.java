package com.test.web.vo;

public class UserVO {
	private int uiNum;
	private String uiName;
	private String uiId;	
	private String uiPwd;
	private String uiGender;
	private String uiBirth;
	private String uiHobby;
	private String uiDesc;
	private String credat;
	private String cretim;
	public int getUiNum() {
		return uiNum;
	}
	public void setUiNum(int uiNum) {
		this.uiNum = uiNum;
	}
	public String getUiName() {
		return uiName;
	}
	public void setUiName(String uiName) {
		this.uiName = uiName;
	}
	public String getUiId() {
		return uiId;
	}
	public void setUiId(String uiId) {
		this.uiId = uiId;
	}
	public String getUiPwd() {
		return uiPwd;
	}
	public void setUiPwd(String uiPwd) {
		this.uiPwd = uiPwd;
	}
	public String getUiGender() {
		return uiGender;
	}
	public void setUiGender(String uiGender) {
		this.uiGender = uiGender;
	}
	public String getUiBirth() {
		return uiBirth;
	}
	public void setUiBirth(String uiBirth) {
		this.uiBirth = uiBirth;
	}
	public String getUiHobby() {
		return uiHobby;
	}
	public void setUiHobby(String uiHobby) {
		this.uiHobby = uiHobby;
	}
	public String getUiDesc() {
		return uiDesc;
	}
	public void setUiDesc(String uiDesc) {
		this.uiDesc = uiDesc;
	}
	public String getCredat() {
		return credat;
	}
	public void setCredat(String credat) {
		this.credat = credat;
	}
	public String getCretim() {
		return cretim;
	}
	public void setCretim(String cretim) {
		this.cretim = cretim;
	}
	@Override
	public String toString() {
		return "UserVO [uiNum=" + uiNum + ", uiName=" + uiName + ", uiId=" + uiId + ", uiPwd=" + uiPwd + ", uiGender="
				+ uiGender + ", uiBirth=" + uiBirth + ", uiHobby=" + uiHobby + ", uiDesc=" + uiDesc + ", credat="
				+ credat + ", cretim=" + cretim + "]" +"\n";
	}
	
}


