package com.test.web.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.test.web.vo.UserVO;

import common.DBCon;

public class UserService {
	public int inertUser(UserVO user) throws SQLException {
		Connection con = DBCon.getCon();
		String sql = "INSERT INTO USER_INFO\r\n"
	            + "(UI_NAME, UI_ID, UI_PWD, UI_GENDER,\r\n"
	            + "UI_BIRTH, UI_HOBBY, UI_DESC)\r\n"
	            + "VALUES(\r\n"
	            + "?,?,?,?,\r\n"
	            + "?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, user.getUiName());
		ps.setString(2, user.getUiId());
		ps.setString(3, user.getUiPwd());
		ps.setString(4, user.getUiGender());
		ps.setString(5, user.getUiBirth());
		ps.setString(6, user.getUiHobby());
		ps.setString(7, user.getUiDesc());	
		return ps.executeUpdate();
	}
	
	public List<UserVO> selectUsers() throws SQLException{
		List<UserVO> users = new ArrayList<>();
		Connection con = DBCon.getCon();
		String sql = "SELECT UI_NUM, UI_NAME, UI_ID, UI_PWD,\r\n"
				+ "UI_GENDER, STR_TO_DATE(UI_BIRTH,'%Y%m%d') AS UI_BIRTH, UI_HOBBY, UI_DESC,\r\n"
				+ "CREDAT,CRETIM\r\n"
				+ "FROM user_info;";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			UserVO user = new UserVO();
			user.setUiNum(rs.getInt("UI_NUM"));
			user.setUiName(rs.getString("UI_Name"));
			user.setUiId(rs.getString("UI_ID"));
			user.setUiPwd(rs.getString("UI_PWD"));
			user.setUiGender(rs.getString("UI_GENDER"));
			user.setUiBirth(rs.getString("UI_BIRTH"));
			user.setUiHobby(rs.getString("UI_HOBBY"));
			user.setUiDesc(rs.getString("UI_DESC"));
			user.setCredat(rs.getString("CREDAT"));
			user.setCretim(rs.getString("CRETIM"));
			users.add(user);
		}
		return users; //리턴은 생명연장
	}
	public static void main(String[] args) {
		UserService us = new UserService();
		try {
			 List<UserVO> users = us.selectUsers();
			 System.out.println(users);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
