package com.test.web.vo;

public class MenuVO {
	private int miNum;
	private String miName;
	private int miPrice;
	private String miDesc;
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
	@Override
	public String toString() {
		return "MenuVO [miNum=" + miNum + ", miName=" + miName + ", miPrice=" + miPrice + ", miCesc=" + miDesc + "]";
	}
	
}
