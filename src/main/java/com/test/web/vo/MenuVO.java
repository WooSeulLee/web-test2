package com.test.web.vo;

public class MenuVO {
	private int miNum;
	private String miName;
	private int miPrice;
	private String miDesc;
	private String miPath;
	
	public int getMiNum() {
		return miNum;
	}
	public void setMiNum(int miNum) {
		this.miNum = miNum;
	}
	public String getMiName() {
		return miName;
	}
	public void setMiName(String miName) {
		this.miName = miName;
	}
	public int getMiPrice() {
		return miPrice;
	}
	public void setMiPrice(int miPrice) {
		this.miPrice = miPrice;
	}
	public String getMiDesc() {
		return miDesc;
	}
	public void setMiDesc(String miDesc) {
		this.miDesc = miDesc;
	}
	public String getMiPath() {
		return miPath;
	}
	public void setMiPath(String miPath) {
		this.miPath = miPath;
	}
	
	@Override
	public String toString() {
		return "MenuVO [miNum=" + miNum + ", miName=" + miName + ", miPrice=" + miPrice + ", miDesc=" + miDesc
				+ ", miPath=" + miPath + "]";
	}
}
