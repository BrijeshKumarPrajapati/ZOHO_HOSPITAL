import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddNewTestServlet extends HttpServlet{
	public void doPost (HttpServletRequest request, HttpServletResponse response) {
		
	
		String name = request.getParameter("testAddName");
		int price = Integer.parseInt(request.getParameter("testAddPrice"));
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "Demo@123");
			System.out.println("Connection is : " + con);
			PreparedStatement stmt = con.prepareStatement("INSERT into  test (testName, testPrice) VALUES(?,?)");
			stmt.setString(1, name);
			stmt.setInt(2, price);

			int i=stmt.executeUpdate();  
			System.out.println(i+" records inserted"); 
			response.getWriter().print("New Test Added Successfully...");
			con.close(); 
		} catch (Exception e) {
			e.printStackTrace();

		}
		
}


}