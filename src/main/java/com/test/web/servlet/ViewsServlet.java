package com.test.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewsServlet")
public class ViewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static String PREFIX = "/WEB-INF/views/";
	private final static String SUFFIX = ".jsp";


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = PREFIX + request.getRequestURI().substring(7) + SUFFIX;

		RequestDispatcher rd = request.getRequestDispatcher(uri);
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
