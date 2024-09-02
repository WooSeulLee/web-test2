package com.test.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.web.service.UserService;

public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService us = new UserService();
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String cmd = request.getRequestURI();
		int idx = cmd.lastIndexOf("/");
		cmd = cmd.substring(idx+1);
		try {
			if("user-list".equals(cmd)) {
				request.setAttribute("users", us.selectUsers());
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/user/user-list.jsp");
				rd.forward(request, response);
				return;
			}else if("user-view".equals(cmd)) {
				
			}else if("user-insert".equals(cmd)) {
				
			}else {
				response.sendError(HttpServletResponse.SC_NOT_FOUND); //404에러
			}
		}catch(SQLException e) {
			
		}
		// 해당 서블릿의 doGet메서드가 실행되기 위해서 만족해야되는 조건
		//1. uri가 반드기 /user로 시작해야한다.
		//2. 메서드가 반드시 GET이여야 한다.
		// /user/user-list
		// /user/user-view?nuNum=1
		// /user/user-insert
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
