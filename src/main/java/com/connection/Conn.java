package com.connection;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conn {
			private static Connection con;
			public static Connection getCon(){
			 try {
			    Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "Demo@123");
			 } catch (Exception e) {
				 e.printStackTrace();
			 }
          return con;			 
}
}