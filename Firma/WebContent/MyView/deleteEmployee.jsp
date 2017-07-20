<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page session="true" import="java.util.ArrayList, MyModel.*" %>
<%@ page import = "java.util.Map" %>
<%@ page import = "java.sql.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Deleting the record...</title>
</head>
<body>

	<% 
		String employee_id = request.getParameter("employee_id");
		String sure = request.getParameter("sure");
		
		if(sure != null && sure.matches("on")){
			
			try {
				ManageEmployees.deleteEmployee(Integer.parseInt(employee_id));
			}
			catch (Exception e) {
				response.sendRedirect("/Firma/MyView/dberror.html");
				return;
			}
			response.sendRedirect("/Firma/MyView/showEmployee.jsp");
			return;
		}
	%>
	<h1>You didn't mark the radio button.</h1>
	<br>
	<a href="../index.html">Return to the main page</a>
	
</body>
</html>