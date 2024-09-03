package com.test.web.vo;

public class CarVO {
	private int ciNum;
	private String ciName;
	private String ciYear;
	public int getCiNum() {
		return ciNum;
	}
	public void setCiNum(int ciNum) {
		this.ciNum = ciNum;
	}
	public String getCiName() {
		return ciName;
	}
	public void setCiName(String ciName) {
		this.ciName = ciName;
	}
	public String getCiYear() {
		return ciYear;
	}
	public void setCiYear(String ciYear) {
		this.ciYear = ciYear;
	}
	@Override
	public String toString() {
		return "CarVO [ciNum=" + ciNum + ", ciName=" + ciName + ", ciYear=" + ciYear + "]";
	}
	
}
