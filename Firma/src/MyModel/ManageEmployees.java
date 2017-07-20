package MyModel;

import java.io.*;
import java.sql.*;
import java.util.*;



public class ManageEmployees {
	private static Connection conn;
	private static ArrayList<EmployeeBean> employeeList;
	private static ArrayList<String> colNames;
	
	public static void setEmployee(int employee_id, String firstName, String lastName, 
			float wage, int position_id, int branch_id, int supervisor) throws SQLException
	{
		try
		{
			conn = getConnection();
			PreparedStatement stmt = conn.prepareStatement("insert into EMPLOYEES (EMPLOYEE_ID, FIRST_NAME, LAST_NAME, WAGE, POSITION_ID, BRANCH_ID, SUPERVISOR_ID) values (?, ?, ?, ?, ?, ?, ?)");
			stmt.setInt(1, employee_id);
			stmt.setString(2, firstName);
			stmt.setString(3, lastName);
			stmt.setFloat(4, wage);
			stmt.setInt(5,position_id);
			stmt.setInt(6, branch_id);
			stmt.setInt(7, supervisor);
			stmt.execute();
			closeConnection(conn);
		}
		catch(SQLException eSQL)
		{
			closeConnection(conn);
			throw eSQL;
		}
	}
	
	public static void deleteEmployee(int employee_id) throws SQLException
	{
		try
		{
			conn = getConnection();
			PreparedStatement stmt = conn.prepareStatement("delete from EMPLOYEES where EMPLOYEE_ID=?;");
			stmt.setInt(1, employee_id);
			stmt.execute();
			closeConnection(conn);
			System.out.printf("deleted %d\n", employee_id);
		}
		catch(Exception e)
		{
			closeConnection(conn);
			throw e;
		}
		closeConnection(conn);
	}
	
	public static ArrayList<String> getEmployeeColNames() //zwraca nazwy kolumn tabeli Pracownicy
	{
		colNames = new ArrayList<String>();
		colNames.add("ID of the Employee");
		colNames.add("First name");
		colNames.add("Last name");
		colNames.add("Wage");
		colNames.add("ID of position");
		colNames.add("ID of branch");
		colNames.add("ID of supervisor");
		
		/*try {
			Connection conn = getConnection();
			DatabaseMetaData md = conn.getMetaData();
			ResultSet rs = md.getTables(null, null, "%", null);
			System.out.printf("Connection established\n");
			while(rs.next()){
				colNames.add(rs.getString(3));
			}
			closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
		
		return colNames;
	}
	
	public static ArrayList<EmployeeBean> getEmployees()
	{
		try
		{
			employeeList = new ArrayList<EmployeeBean>();
			conn = getConnection();
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("Select EMPLOYEE_ID, FIRST_NAME, LAST_NAME, WAGE, BRANCH_ID, POSITION_ID, SUPERVISOR_ID From EMPLOYEES");
			
			while(rs.next())
			{
				employeeList.add(new EmployeeBean(rs.getInt("EMPLOYEE_ID"), rs.getString("FIRST_NAME"),
						rs.getString("LAST_NAME"), rs.getFloat("WAGE"), rs.getInt("BRANCH_ID"),
						rs.getInt("POSITION_ID"), rs.getInt("SUPERVISOR_ID")));
			}
			
			rs.close();
			stat.close();
			closeConnection(conn);
			return employeeList;
		}
		catch(SQLException eSQL)
		{
			eSQL.printStackTrace();
			return employeeList;
		}
	}
	
	public static Connection getConnection() throws SQLException 
	{
		Connection conn;
		
		System.out.printf("Establishing connection...\n");
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.printf("Establishing connection failed.\n");
			e.printStackTrace();
		}
		conn = DriverManager.getConnection("jdbc:mysql://localhost/employees", "root", "qwerty");

		return conn;
	}
	
	public static void closeConnection(Connection conn) throws SQLException 
	{
		System.out.printf("Closing connection\n");
		conn.close();
	}
	
}
