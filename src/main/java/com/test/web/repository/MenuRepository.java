package com.test.web.repository;

import java.sql.*;
import java.util.*;
import com.test.web.vo.MenuVO;

import common.DBCon;

public class MenuRepository {
	
	public int insertMenu(MenuVO menu) {
		try(Connection con = DBCon.getCon();) {
			String sql = "INSERT INTO MENU_INFO(MI_NAME, MI_PRICE, MI_DESC, MI_PATH)\r\n"
					+ "VALUES(?, ?, ?, ?)";
			try(PreparedStatement ps = con.prepareStatement(sql)) {
				ps.setString(1, menu.getMiName());
				ps.setInt(2, menu.getMiPrice());
				ps.setString(3, menu.getMiDesc());
				ps.setString(4, menu.getMiPath());
				return ps.executeUpdate();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return 0;
	}
	
	public int updateMenu(MenuVO menu) {
		try(Connection con = DBCon.getCon();){
			String sql = "UPDATE MENU_INFO\r\n"
					+ "SET MI_NAME=?,\r\n"
					+ "MI_PRICE=?,\r\n"
					+ "MI_DESC=?\r\n"
					+ " WHERE MI_NUM=?";
			try(PreparedStatement ps = con.prepareStatement(sql)){
				ps.setString(1, menu.getMiName());
				ps.setInt(2, menu.getMiPrice());
				ps.setString(3, menu.getMiDesc());
				ps.setInt(4, menu.getMiNum());
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
		
	public int deleteMenu(int miNum) {
		try(Connection con = DBCon.getCon();){
			String sql = "DELETE FROM MENU_INFO WHERE MI_NUM=?";
			try(PreparedStatement ps = con.prepareStatement(sql)){
				ps.setInt(1, miNum);
				return ps.executeUpdate();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public List<MenuVO> selectMenus(){
		List<MenuVO> menus = new ArrayList<>();
		try(Connection con = DBCon.getCon();){
			String sql = "SELECT Mi_NUM, MI_NAME, MI_PRICE, MI_DESC, MI_PATH\r\n"
					+ " FROM MENU_INFO";
			try(PreparedStatement ps = con.prepareStatement(sql)){
				try(ResultSet rs = ps.executeQuery()){
					while(rs.next()) {
						MenuVO menu = new MenuVO();
						menu.setMiNum(rs.getInt("MI_NUM"));
						menu.setMiName(rs.getString("MI_NAME"));
						menu.setMiPrice(rs.getInt("MI_PRICE"));
						menu.setMiPath(rs.getString("MI_PATH"));
						menus.add(menu);
					}
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return menus;
	}
	
	
	public MenuVO selectMenu(int miNum) {
		try(Connection con = DBCon.getCon()){
			String sql ="SELECT Mi_NUM, MI_NAME, MI_PRICE, MI_DESC, MI_PATH\r\n"
					+ "FROM MENU_INFO WHERE MI_NUM =?";
			try(PreparedStatement ps = con.prepareStatement(sql)){
				ps.setInt(1, miNum);
				try(ResultSet rs = ps.executeQuery()){
					if(rs.next()) {
					MenuVO menu = new MenuVO();
					menu.setMiNum(rs.getInt("MI_NUM"));
					menu.setMiName(rs.getString("MI_NAME"));
					menu.setMiPrice(rs.getInt("MI_PRICE"));
					menu.setMiDesc(rs.getString("MI_DESC"));
					menu.setMiPath(rs.getString("MI_PATH"));
					return menu;
					}
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
		public static void main(String[] args) {
			MenuRepository mr = new MenuRepository();
			List<MenuVO> menus = mr.selectMenus();
			System.out.println(menus);
			MenuVO menu = mr.selectMenu(3);
			System.out.println(menu);
			
			menu.setMiDesc("맛있당");
			mr.updateMenu(menu);
			menu = mr.selectMenu(9);
			System.out.println(menu);
		}
		
	}

	
	

