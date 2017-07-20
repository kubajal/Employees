<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true" import="java.util.ArrayList, MyModel.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List of employees</title>
<link rel="stylesheet" type="text/css" href="CSS/display.css">
</head>
<body>
<table border = 1 id="table">
<% //Scriptlet 1 - ta część zostanie przekształcona do kodu HTML
	ArrayList<String> colNames = ManageEmployees.getEmployeeColNames();

	out.print("<tr>");
	for(int i = 0; i < colNames.size(); i++)
	{
		out.print("<th>");
		out.print(colNames.get(i));
		out.print("</th>");
	}
	out.print("</tr>");
	
	ArrayList<EmployeeBean> employeeList = ManageEmployees.getEmployees();
	
	for(int i = 0; i < employeeList.size(); i++)
	{
		out.print("<tr>");
		out.print("<td>");
		out.print(employeeList.get(i).getEmployeeID());
		out.print("</td>");
		out.print("<td>");
		out.print(employeeList.get(i).getFirstName());
		out.print("</td>");
		out.print("<td>");
		out.print(employeeList.get(i).getLastName());
		out.print("</td>");
		out.print("<td>");
		out.print(employeeList.get(i).getWage());
		out.print("</td>");
		out.print("<td>");
		out.print(employeeList.get(i).getPositionID());
		out.print("</td>");
		out.print("<td>");
		out.print(employeeList.get(i).getBranchID());
		out.print("</td>");		
		out.print("<td>");
		out.print(employeeList.get(i).getSupervisorID());
		out.print("</td>");
		out.print("</tr>");
	}
%>
</table>
<br>
<a href="../index.html">Return to the main page</a>
</body>
</html>