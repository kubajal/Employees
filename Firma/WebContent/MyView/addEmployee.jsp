<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true" import="java.util.ArrayList, MyModel.*" %>
<%@ page import = "java.util.Map" %>
<%@ page import = "java.sql.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="CSS/display.css">
<title>Adding the employee to the database...</title>
</head>
<%
	String employee_id = request.getParameter("employee_id");
	String firstName = request.getParameter("firstname");
	String lastName = request.getParameter("lastname");
	String wage = request.getParameter("wage");
	String position_id = request.getParameter("position");
	String branch_id = request.getParameter("branch");
	String supervisor = request.getParameter("supervisor");
	
	try {
		ManageEmployees.setEmployee(Integer.parseInt(employee_id), firstName, lastName, Float.parseFloat(wage), Integer.parseInt(position_id), Integer.parseInt(branch_id), Integer.parseInt(supervisor));
	}
	catch (Exception e) {
		response.sendRedirect("/Firma/MyView/dberror.html");
		return;
	}
	response.sendRedirect("/Firma/MyView/showEmployee.jsp");
%>
</body>
</html>