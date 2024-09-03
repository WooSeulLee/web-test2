package com.test.web.util;

public class CmdUtil {
	
	public static String getCmd(String uri) {
		int idx = uri.lastIndexOf("/");
		if(idx!=-1) {
			return uri.substring(idx+1);
		}
		return null;
	}
	
//	public static void main(String[] args) {
//		System.out.println(getCmd("/car/test"));
//		System.out.println(getCmd("/car///1234564"));
//		System.out.println(getCmd("/car/dfgdf"));
//	}
}
