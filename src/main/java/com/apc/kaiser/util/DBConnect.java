package com.apc.kaiser.util;

import java.sql.*;  

class DBConnect{  
		
	public static void main(String args[]){  
		
	try{  
	Class.forName("com.mysql.jdbc.Driver");  
	Connection con=DriverManager.getConnection(  
	"jdbc:mysql://127.0.0.1:3306/pcs","root","root");  
	//here sonoo is database name, root is username and password  
	Statement stmt=con.createStatement();  
	ResultSet rs=stmt.executeQuery("select * from caforms");  
	while(rs.next())  
	System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getString(5)+"  "+rs.getString(6));  
	con.close();  
	}catch(Exception e){ System.out.println(e);}  
	}  
}  
