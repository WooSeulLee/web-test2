<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
pageContext.setAttribute("name", "이우슬");
request.setAttribute("name", "동동이");
session.setAttribute("name", "선풍기");
application.setAttribute("name", "학원");

RequestDispatcher rd = request.getRequestDispatcher("/scope/req2.jsp");
rd.forward(request,response);
%>
