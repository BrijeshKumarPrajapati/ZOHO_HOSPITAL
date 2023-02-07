import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.connection.*;
public class AddNewTestServlet extends HttpServlet{
	protected void doPost (HttpServletRequest request, HttpServletResponse response) {
		
	
	    String testName = request.getParameter("testAddName");
		int testPrice = Integer.parseInt(request.getParameter("testAddPrice"));
		
		try {
			
			Connection con = Conn.getCon();
			System.out.println("Connection is : " + con);
			PreparedStatement stmt = con.prepareStatement("INSERT into  test (testName, testPrice) VALUES(?,?)");
			stmt.setString(1, testName);
			stmt.setInt(2, testPrice);

			int i=stmt.executeUpdate();  
			System.out.println(i+" records inserted"); 
			response.getWriter().print("New Test Added Successfully...");
			con.close(); 
		} catch (Exception e) {
			e.printStackTrace();

		}
		
}


}